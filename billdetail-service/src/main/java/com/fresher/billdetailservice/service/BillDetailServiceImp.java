package com.fresher.billdetailservice.service;

import com.fresher.billdetailservice.entity.BillDetail;
import com.fresher.billdetailservice.repo.BillDetailRepository;
import com.fresher.billdetailservice.response.BillDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailServiceImp implements BillDetailService {

    BillDetailRepository billDetailRepository;

    @Override
    public List<BillDetailResponse> getBillDetailAll() {
        List<BillDetailResponse> = billDetailRepository.findAll().
                stream().map()
        return
    }

    @Override
    public BillDetail createBillDetail(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
        return billDetail;
    }

    @Override
    public BillDetail findBillDetail(Long id) {
        BillDetail detail = billDetailRepository.findById(id).get();
        return detail;
    }

    @Override
    public List<BillDetail> findBillDetailByTimeCheckIn(BillDetail billDetail) {
        return null;
    }

    @Override
    public List<BillDetail> findBillDetailByTimeCheckOut(BillDetail billDetail) {
        return null;
    }

    @Override
    public List<BillDetail> findBillDetailByTotalTime(BillDetail billDetail) {
        return null;
    }

    @Override
    public List<BillDetail> SoftBillDetailByAmountMoneyASC(BillDetail billDetail) {
        return null;
    }

    @Override
    public List<BillDetail> SoftBillDetailByAmountMoneyDESC(BillDetail billDetail) {
        return null;
    }
}
