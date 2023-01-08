package com.fresher.billdetailservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.fresher.billdetailservice.controller", "com.fresher.billdetailservice.service"})
@EntityScan("com.fresher.billdetailservice.entity")
@EnableJpaRepositories("com.fresher.billdetailservice.repo")
@EnableFeignClients("com.fresher.billdetailservice.feignClients")
public class BilldetailServiceApplication {

    @Value("${room.service.url}")
    public String roomServiceUrl;

    public static void main(String[] args) {
        SpringApplication.run(BilldetailServiceApplication.class, args);
    }

}
