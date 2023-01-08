package com.fresher.billservice.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private Date birthday;
    private String personId;
    private boolean gender;

    private AddressResponse addressResponse;

}
