package com.fresher.msa.customerservice.repo;

import com.fresher.msa.customerservice.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long> {

    @Query(value = "select * from customers where phone_number like %:phone%", nativeQuery = true)
    public List<Customers> findCustomerByPhoneNumber(@Param("phone") String phone);
}
