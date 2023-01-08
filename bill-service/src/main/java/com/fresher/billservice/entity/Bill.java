package com.fresher.billservice.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "bill")
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBill;
    @Column(name = "name")
    private String name;
    @Column(name = "time_stamp", columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @Column(name = "price")
    private Double price;
    @Column(name = "status")
    private boolean status;
}
