package com.fresher.msa.customerservice.services.imp;

import com.fresher.msa.customerservice.entity.Address;
import com.fresher.msa.customerservice.entity.Customers;
import com.fresher.msa.customerservice.repo.AddressRepo;
import com.fresher.msa.customerservice.repo.CustomerRepo;
import com.fresher.msa.customerservice.respone.AddressResponse;
import com.fresher.msa.customerservice.respone.CustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AddressRepo addressRepo;

    @Override
    public List<Customers> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customers saveCustomer(Customers customers) {
//        Customers customers = new Customers();
//        customers.setIdCustomer(customerResponse.getIdCustomer());
//        customers.setFirstName(customerResponse.getFirstName());
//        customers.setLastName(customerResponse.getLastName());
//        customers.setPersonId(customerResponse.getPersonId());
//        customers.setGender(customerResponse.isGender());
//        customers.setBirthday(customerResponse.getBirthday());
//        customers.setIdAddress(customerResponse.getAddressResponse().getIdAddress());
        customerRepo.save(customers);
        return customers;
    }

    @Override
    public Customers updateCustomer(Customers customers) {
        customerRepo.save(customers);
        return customers;
    }

    @Override
    public CustomerResponse findCustomerById(Long id) {
        log.info("id: {}", id);
        Customers customers = customerRepo.findById(id).get();
        Address address = addressRepo.findById(customers.getIdAddress()).get();
        AddressResponse addressResponse =new AddressResponse(address);
        CustomerResponse customerResponse = new CustomerResponse(customers, addressResponse);
        return customerResponse;
    }

    @Override
    public List<Customers> findCustomerByPhoneNumber(String phoneNumber) {
        List<Customers> customersList = customerRepo.findCustomerByPhoneNumber(phoneNumber);
//        List<CustomerResponse> lisCustomReponse= new ArrayList<>();
//        customersList.stream().forEach(customers ->
//        {
//            Address address= addressRepo.findById(customers.getIdAddress()).get();
//            AddressResponse addressResponse = new AddressResponse(address);
//            CustomerResponse customers1 = new CustomerResponse(customers, addressResponse);
//            lisCustomReponse.add(customers1);
//        });
        return customersList;
    }
}
