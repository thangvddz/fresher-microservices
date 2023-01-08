package com.fresher.billservice.feignClients;


import com.fresher.billservice.response.CustomerResponeId;
import com.fresher.billservice.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "customer-service",
        path = "/api/Customers")
public interface CustomerFeignClient {
    @GetMapping("/getCustomerById/{id}")
    public CustomerResponse findById(@PathVariable(name = "id") Long id);

    @GetMapping("/search")
    List<CustomerResponeId> findCustomerByNumberPhone(@RequestParam("phoneNumber") String phoneNumber);
}
