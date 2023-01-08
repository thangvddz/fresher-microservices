package com.fresher.billservice.repo;

import com.fresher.billservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {
    @Query(value = "select top 1 * from bill order by time_stamp DESC", nativeQuery = true)
    Bill findBillByNewCreate();
}
