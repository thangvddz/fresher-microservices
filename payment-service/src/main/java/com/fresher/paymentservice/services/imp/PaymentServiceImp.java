package com.fresher.paymentservice.services.imp;

import com.fresher.paymentservice.entity.PaymentType;
import com.fresher.paymentservice.repo.TypePaymentRepo;
import com.fresher.paymentservice.response.TypePaymentResponse;
import com.fresher.paymentservice.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImp implements PaymentServices {

    @Autowired
    TypePaymentRepo typePaymentRepo;

    @Override
    public List<TypePaymentResponse> getAllTypePayment() {
        List<PaymentType> list = typePaymentRepo.findAll();
        List<TypePaymentResponse> response = new ArrayList<>();
        list.stream().forEach(typePayment -> {
            TypePaymentResponse typePaymentResponse = new TypePaymentResponse();
            typePaymentResponse.setNamePaymentType(typePayment.getNamePaymentType());
            typePaymentResponse.setStatus(typePayment.isStatus());
            response.add(typePaymentResponse);
        });
        return response;
    }

    @Override
    public List<PaymentType> getAllTypePaymentRaw() {
        return typePaymentRepo.findAll();
    }

    @Override
    public PaymentType createTypePayment(PaymentType typePayment) {
        return typePaymentRepo.save(typePayment);
    }

    @Override
    public PaymentType updateTypePayment(PaymentType typePayment) {
        return typePaymentRepo.save(typePayment);
    }

    @Override
    public PaymentType disableTypePayment(Long id) {
        PaymentType typePayment = typePaymentRepo.findById(id).get();
        if (typePayment != null){
            typePayment.setStatus(false);
            typePaymentRepo.save(typePayment);
        }
        return typePayment;
    }
}
