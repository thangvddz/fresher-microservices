package com.fresher.paymentservice.services;


import com.fresher.paymentservice.entity.PaymentType;
import com.fresher.paymentservice.response.TypePaymentResponse;

import java.util.List;

public interface PaymentServices {
    List<TypePaymentResponse> getAllTypePayment();
    List<PaymentType> getAllTypePaymentRaw();
    PaymentType createTypePayment(PaymentType typePayment);
    PaymentType updateTypePayment(PaymentType typePayment);
    PaymentType disableTypePayment(Long id);
}
