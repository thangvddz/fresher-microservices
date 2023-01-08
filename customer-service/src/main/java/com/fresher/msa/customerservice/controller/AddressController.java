package com.fresher.msa.customerservice.controller;

import com.fresher.msa.customerservice.entity.Address;
import com.fresher.msa.customerservice.respone.AddressResponse;
import com.fresher.msa.customerservice.services.imp.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/getAllAddress")
    public ResponseEntity<List<Address>> getAllAddress(){
        return new ResponseEntity<>(addressService.getAllArress(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        addressService.saveAddress(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
