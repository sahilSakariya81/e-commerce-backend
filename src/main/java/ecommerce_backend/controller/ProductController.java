package ecommerce_backend.controller;

import ecommerce_backend.DTO.ProductRequestDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.ProductTable;
import ecommerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    ResponseDTO add(@RequestBody ProductRequestDTO pr){
        return productService.addProduct(pr);
    }
}
