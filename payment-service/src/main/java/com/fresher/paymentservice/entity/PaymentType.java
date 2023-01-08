package com.fresher.paymentservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "payment_type")
@Data
public class PaymentType {
    @Id
    private Long idPay;
    @Column(name = "name_payment_type")
    private String namePaymentType;
    @Column(name = "status")
    private boolean status;
}
