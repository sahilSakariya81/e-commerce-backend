package ecommerce_backend.controller;

import ecommerce_backend.DTO.OrderDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("place")
    ResponseDTO placeOrder(@RequestBody OrderDTO od){
        return orderService.placeOrder(od);
    }
}
