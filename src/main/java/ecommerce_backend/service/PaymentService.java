package ecommerce_backend.service;

import ecommerce_backend.DTO.CardPaymentDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.DTO.UPIPaymentDTO;
import ecommerce_backend.model.*;
import ecommerce_backend.repository.OrderItemRepository;
import ecommerce_backend.repository.PaymentRepository;
import ecommerce_backend.repository.ProductRepository;
import ecommerce_backend.repository.UserTableRepository;
import org.apache.catalina.User;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    OrderItemRepository oiRepo;

    @Autowired
    ProductRepository pRepo;

    @Autowired
    PaymentRepository pRepo2;

    @Autowired
    UserTableRepository uRepo;


    public ResponseDTO paymentUpi(UPIPaymentDTO upd){
        PaymentTable pt = pRepo2.findByUserId(upd.getUserId());

        UserTable userid = uRepo.findById(upd.getUserId()).orElse(null);
        if(userid == null){
            return new ResponseDTO("user not found", HttpStatus.OK);
        }


        if(pt.getStatus().equals("PENDING")){
            pt.setStatus("SUCCESS");

            OrderTable order = pt.getOder();

            List<OrderItemTable> items = oiRepo.findByOrder(order);

            for(OrderItemTable item : items){
                ProductTable product = item.getProduct();
                int newStock = product.getStock() - item.getQuantity();
                product.setStock(newStock);
                pRepo.save(product);
            }
        }

        pRepo2.save(pt);

        return new ResponseDTO("Payment successful", HttpStatus.OK);
    }

    public ResponseDTO paymentCard(CardPaymentDTO cpd){
        PaymentTable pt = pRepo2.findByUserId(cpd.getUserId());

        UserTable userid = uRepo.findById(cpd.getUserId()).orElse(null);
        if(userid == null){
            return new ResponseDTO("user not found", HttpStatus.OK);
        }


        if(pt.getStatus().equals("PENDING")){
            pt.setStatus("SUCCESS");

            OrderTable order = pt.getOder();

            List<OrderItemTable> items = oiRepo.findByOrder(order);

            for(OrderItemTable item : items){
                ProductTable product = item.getProduct();
                int newStock = product.getStock() - item.getQuantity();
                product.setStock(newStock);
                pRepo.save(product);
            }
        }

        pRepo2.save(pt);

        return new ResponseDTO("Payment successful", HttpStatus.OK);
    }
}
