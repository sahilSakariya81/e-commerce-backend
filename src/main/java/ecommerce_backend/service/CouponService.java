package ecommerce_backend.service;

import ecommerce_backend.DTO.CouponDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CouponTable;
import ecommerce_backend.model.ProductTable;
import ecommerce_backend.repository.CouponRepository;
import ecommerce_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseDTO addCoupon(CouponDTO dto) {

        CouponTable coupon = new CouponTable();

        coupon.setCode(dto.getCode());
        coupon.setDiscount(dto.getDiscount());
        coupon.setExpiryDate(dto.getExpiryDate());
        coupon.setActive(dto.isActive());

        List<ProductTable> products = productRepository.findAllById(dto.getProductIds());

        coupon.setProducts(products);

        couponRepository.save(coupon);

        return new ResponseDTO("Coupon Added", HttpStatus.OK);
    }
}