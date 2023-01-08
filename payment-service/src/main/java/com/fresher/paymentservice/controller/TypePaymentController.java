package com.fresher.paymentservice.controller;

import com.fresher.paymentservice.entity.PaymentType;
import com.fresher.paymentservice.response.TypePaymentResponse;
import com.fresher.paymentservice.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment/")
public class TypePaymentController {
    @Autowired
    PaymentServices paymentServices;

    @GetMapping("/getAllTypePaymentRaw")
    public ResponseEntity<List<PaymentType>> getAllTypePayment(){
        return new ResponseEntity<>(paymentServices.getAllTypePaymentRaw(), HttpStatus.OK);
    }
    @GetMapping("/getAllTypePayment")
    public ResponseEntity<List<TypePaymentResponse>> getAllTypePaymentResponse(){
        return new ResponseEntity<>(paymentServices.getAllTypePayment(), HttpStatus.OK);
    }
}
