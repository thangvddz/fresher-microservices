package com.fresher.billservice.service;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.entity.BillDetail;
import com.fresher.billservice.response.BillDetailResponse;

import java.util.List;
import java.util.Map;

public interface BillDetailService {
    List<BillDetailResponse> getBillDetailAll();
    List<BillDetail> getBillDetailRawAll();
    BillDetail createBillDetail(BillDetail billDetail);
    BillDetail findBillDetail(Long id);
    Map<Long, List<BillDetailResponse>> findBillDetailByPhoneNumber(String phoneNumber);
    List<BillDetail> findBillDetailByIdCustomer(Long id);
    List<BillDetail> findBillDetailByIdRoom(Long id);
    List<BillDetail> findBillDetailByIdBill(Long id);
    BillDetail checkOut(Long id);
    boolean isEmptyRoom(Long idRoom);
}
