package ecommerce_backend.service;

import ecommerce_backend.DTO.OrderDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.*;
import ecommerce_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderItemRepository oiRepo;

    @Autowired
    OrderRepository oRepo;

    @Autowired
    UserTableRepository uRepo;

    @Autowired
    CartRepository cRepo;

    @Autowired
    PaymentRepository pRepo;

    @Autowired
    ProductRepository pRepo2;

    public ResponseDTO placeOrder(OrderDTO dto){
        UserTable user = uRepo.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User Not Found"));

        List<CartTable> cartItems = cRepo.findByUser(dto.getUserId());

        if(cartItems.isEmpty()){
            throw new RuntimeException("Cart Is Empty");
        }

        OrderTable order = new OrderTable();
        order.setUser(user);
        order.setOrderDate(LocalDate.now());
        order.setStatus("PLACED");

        oRepo.save(order);   // ✅ SAVE ORDER FIRST

        double total = 0;

        for(CartTable cart : cartItems){

            ProductTable product = cart.getProduct();

            OrderItemTable item = new OrderItemTable();

            item.setOrder(order);   // now order has ID
            item.setProduct(product);
            item.setQuantity(cart.getQuantity());

            double price = product.getPrice();

            item.setPrice(price);
            item.setTotalPrice(price * cart.getQuantity());

            total += item.getTotalPrice();

            oiRepo.save(item);  // now works
        }

        order.setTotalAmount(total);
        oRepo.save(order);

        PaymentTable payment = new PaymentTable();
        payment.setAmount(total);
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setStatus("PENDING");
        payment.setOder(order);
        payment.setUser(user);

        if(dto.getPaymentMethod().equals("COD")){

            List<OrderItemTable> items = oiRepo.findByOrder(order);

            for(OrderItemTable item : items){
                ProductTable product = item.getProduct();
                int newStock = product.getStock() - item.getQuantity();
                product.setStock(newStock);
                pRepo2.save(product);
            }
            return  new ResponseDTO("Order placed successfully" , HttpStatus.OK);
        }

        pRepo.save(payment);
        cRepo.deleteAll(cartItems);

        return  new ResponseDTO("Pay The Pending Payment , Your Pending Payment is - " + total , HttpStatus.OK);
    }
}
