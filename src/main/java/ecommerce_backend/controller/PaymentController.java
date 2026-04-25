package ecommerce_backend.controller;

import ecommerce_backend.DTO.CardPaymentDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.DTO.UPIPaymentDTO;
import ecommerce_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("upi")
    ResponseDTO upi(@RequestBody UPIPaymentDTO upd){
        return paymentService.paymentUpi(upd);
    }

    @PostMapping("card")
    ResponseDTO card(@RequestBody CardPaymentDTO cpd){
        return paymentService.paymentCard(cpd);
    }
}
