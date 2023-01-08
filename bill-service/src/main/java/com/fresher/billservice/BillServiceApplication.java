package com.fresher.billservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.fresher.billservice.controller", "com.fresher.billservice.service.imp"})
@EnableJpaRepositories("com.fresher.billservice.repo")
@EntityScan("com.fresher.billservice.entity")
@EnableFeignClients("com.fresher.billservice.feignClients")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class BillServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillServiceApplication.class, args);
    }

}
