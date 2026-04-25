package ecommerce_backend.service;

import ecommerce_backend.DTO.CartRequestDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CartTable;
import ecommerce_backend.model.ProductTable;
import ecommerce_backend.model.UserTable;
import ecommerce_backend.repository.CartRepository;
import ecommerce_backend.repository.ProductRepository;
import ecommerce_backend.repository.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserTableRepository userTableRepository;

    @Autowired
    ProductRepository productRepository;

    public ResponseDTO addToCart(CartRequestDTO cart){


        UserTable user = userTableRepository.findById(cart.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProductTable product = productRepository.findById(cart.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartTable c = new CartTable();


        c.setUser(user);
        c.setProduct(product);
        c.setQuantity(cart.getQuantity());

        cartRepository.save(c);

        return new ResponseDTO("Added to cart", HttpStatus.OK);
    }
}
