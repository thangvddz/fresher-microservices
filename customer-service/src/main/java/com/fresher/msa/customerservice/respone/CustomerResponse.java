package com.fresher.msa.customerservice.respone;

import com.fresher.msa.customerservice.entity.Customers;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
@Data
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private Date birthday;
    private String personId;
    private boolean gender;

    private String email;
    private String phoneNumber;
    private AddressResponse addressResponse;

    public CustomerResponse(Customers customers, AddressResponse addressResponse1){
        this.firstName = customers.getFirstName();
        this.lastName = customers.getLastName();
        this.birthday = customers.getBirthday();
        this.personId = customers.getPersonId();
        this.gender = customers.isGender();
        this.addressResponse = addressResponse1;
        this.email = customers.getEmail();
        this.phoneNumber = customers.getPhoneNumber();
    }
}
