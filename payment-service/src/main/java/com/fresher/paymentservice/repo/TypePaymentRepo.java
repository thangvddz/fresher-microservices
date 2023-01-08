package com.fresher.paymentservice.repo;

import com.fresher.paymentservice.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaymentRepo extends JpaRepository<PaymentType, Long> {

    @Query(value = "select * from payment_type where name_payment_type like %:name%",nativeQuery = true)
    PaymentType findTypePaymentByName(@Param("name") String name);
}
