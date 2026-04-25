package ecommerce_backend.controller;

import ecommerce_backend.DTO.CouponDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CouponTable;
import ecommerce_backend.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping("/addcoupon")
    ResponseDTO addCoupon(@RequestBody CouponDTO cd){
        return couponService.addCoupon(cd);
    }
}
