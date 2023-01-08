package com.fresher.msa.customerservice.services.imp;

import com.fresher.msa.customerservice.entity.Address;
import com.fresher.msa.customerservice.repo.AddressRepo;
import com.fresher.msa.customerservice.respone.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Override
    public List<Address> getAllArress() {
        return addressRepo.findAll();
    }

    @Override
    public Address saveAddress(Address addressResponse) {
        addressRepo.save(addressResponse);
        return addressResponse;
    }
}
