package com.fresher.billservice.service;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.response.BillResponse;

import java.util.List;

public interface BillService {
    List<Bill> getAllBill();
    Bill addBill(Bill bill);
    Bill disableBill(Long id);
    BillResponse findBillById(Long id);
    Bill findBillNewCreate();
    public BillResponse findDetailResponseById(Long id);
}
