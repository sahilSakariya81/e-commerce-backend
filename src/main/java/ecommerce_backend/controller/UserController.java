package ecommerce_backend.controller;

import ecommerce_backend.DTO.LoginDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.UserTable;
import ecommerce_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody @Valid UserTable ut){
        return userService.register(ut);
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody @Valid LoginDTO ld){
        return userService.login(ld);
    }
}
