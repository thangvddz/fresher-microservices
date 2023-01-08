package com.fresher.billservice.repo;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
    @Query(value = "select * from bill_detail where id_customer= :id and status=true", nativeQuery = true)
    public List<BillDetail> findBillDetailByIdCustomer(@Param("id") Long id);

    @Query(value = "select * from bill_detail where id_room= :id and status=true", nativeQuery = true)
    public BillDetail checkEmptyRoom(@Param("id") Long id);
    @Query(value = "select * from bill_detail where id_room= :id and status=true", nativeQuery = true)
    public List<BillDetail> findBillDetailByIdRoom(@Param("id") Long id);

    @Query(value = "select * from bill_detail where id_bill= :id and status=true", nativeQuery = true)
    public List<BillDetail> findBillDetailByIdBill(@Param("id") Long id);

    @Query(value = "select * from bill_detail where id_room= :id and status=true", nativeQuery = true)
    public BillDetail setCheckOutForBillDetail(@Param("id") Long id);
}
