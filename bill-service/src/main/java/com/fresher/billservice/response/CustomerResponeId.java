package com.fresher.billservice.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class CustomerResponeId {
    private Long idCustomer;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String personId;
    private boolean gender;
    private Long idAddress;
    private String email;
    private String phoneNumber;
}
