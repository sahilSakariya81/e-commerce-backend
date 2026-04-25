package ecommerce_backend.controller;

import ecommerce_backend.DTO.CartRequestDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CartTable;
import ecommerce_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;


    @PostMapping("/add")
    ResponseDTO addToCart(@RequestBody CartRequestDTO ct){
        return cartService.addToCart(ct);
    }
}
