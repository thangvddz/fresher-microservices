package com.fresher.msa.customerservice.services.imp;

import com.fresher.msa.customerservice.entity.Address;
import com.fresher.msa.customerservice.respone.AddressResponse;

import java.util.List;

public interface AddressService {
    List<Address> getAllArress();
    Address saveAddress(Address addressResponse);
}
