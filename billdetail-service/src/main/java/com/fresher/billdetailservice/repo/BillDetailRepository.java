package com.fresher.billdetailservice.repo;

import com.fresher.billdetailservice.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
}
