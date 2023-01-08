package com.fresher.billdetailservice.service;

import com.fresher.billdetailservice.entity.BillDetail;
import com.fresher.billdetailservice.response.BillDetailResponse;

import java.util.List;

public interface BillDetailService {
    List<BillDetailResponse> getBillDetailAll();
    BillDetail createBillDetail(BillDetail billDetail);
    BillDetail findBillDetail(Long id);
    List<BillDetail> findBillDetailByTimeCheckIn(BillDetail billDetail);
    List<BillDetail> findBillDetailByTimeCheckOut(BillDetail billDetail);
    List<BillDetail> findBillDetailByTotalTime(BillDetail billDetail);
    List<BillDetail> SoftBillDetailByAmountMoneyASC(BillDetail billDetail);
    List<BillDetail> SoftBillDetailByAmountMoneyDESC(BillDetail billDetail);
}
