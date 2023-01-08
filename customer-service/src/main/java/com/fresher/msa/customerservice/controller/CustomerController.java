package com.fresher.msa.customerservice.controller;

import com.fresher.msa.customerservice.entity.Address;
import com.fresher.msa.customerservice.entity.Customers;
import com.fresher.msa.customerservice.respone.AddressResponse;
import com.fresher.msa.customerservice.respone.CustomerResponse;
import com.fresher.msa.customerservice.services.imp.AddressService;
import com.fresher.msa.customerservice.services.imp.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customers>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<CustomerResponse> getCustomerByID(@PathVariable(name = "id") Long id){
        CustomerResponse customerResponse = customerService.findCustomerById(id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customers>> getCustomerByPhoneNumber(@RequestParam(name = "phoneNumber") String phone){
        List<Customers> customerResponse = customerService.findCustomerByPhoneNumber(phone);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers){
        customerService.saveCustomer(customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customers> updateCustomer(@RequestBody Customers customers){
        customerService.saveCustomer(customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
