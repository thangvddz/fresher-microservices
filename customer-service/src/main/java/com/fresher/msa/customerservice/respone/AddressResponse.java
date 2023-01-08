package com.fresher.msa.customerservice.respone;

import com.fresher.msa.customerservice.entity.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AddressResponse {
    private String city;
    private String distric;
    private String details;

    public AddressResponse(Address address){
        this.city = address.getCity();
        this.distric = address.getDistric();
        this.details = address.getDetails();
    }
}
