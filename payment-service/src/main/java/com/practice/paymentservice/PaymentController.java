package com.practice.paymentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/api/v1")
public class PaymentController {

    @GetMapping("/msg")
    public String getMessage(){
        return "Response from Payment Service";
    }
}
