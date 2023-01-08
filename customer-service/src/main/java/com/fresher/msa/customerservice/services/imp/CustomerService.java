package com.fresher.msa.customerservice.services.imp;

import com.fresher.msa.customerservice.entity.Customers;
import com.fresher.msa.customerservice.respone.AddressResponse;
import com.fresher.msa.customerservice.respone.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<Customers> getAllCustomer();
    Customers saveCustomer(Customers customerResponse);
    Customers updateCustomer(Customers customerResponse);
    CustomerResponse findCustomerById(Long id);
    List<Customers> findCustomerByPhoneNumber(String phoneNumber);
}
