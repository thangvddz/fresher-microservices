package com.fresher.msa.customerservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "customers")
@Data
public class Customers {
    @Id
    @Column(name = "id_cusomer")
    private BigInteger idCustomer;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "person_id")
    private String personId;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "id_address")
    private Long idAddress;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
}
