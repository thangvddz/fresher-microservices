package com.fresher.msa.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    private int idAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "distric")
    private String distric;
    @Column(name = "details")
    private String details;
}
