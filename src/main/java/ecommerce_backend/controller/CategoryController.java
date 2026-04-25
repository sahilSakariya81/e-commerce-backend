package ecommerce_backend.controller;

import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CategoryTable;
import ecommerce_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    ResponseDTO categoryAdd(@RequestBody CategoryTable ct){
        return categoryService.addCategory(ct);
    }
}
