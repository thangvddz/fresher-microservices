package com.fresher.billdetailservice.controller;

import com.fresher.billdetailservice.entity.BillDetail;
import com.fresher.billdetailservice.response.BillDetailResponse;
import com.fresher.billdetailservice.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-detail")
public class BillDetailController {
    @Autowired
    BillDetailService billDetailService;

    @GetMapping("/getAllBillDetail")
    public ResponseEntity<List<BillDetailResponse>> getAllBillDetail(){
        return new ResponseEntity<>(billDetailService.getBillDetailAll(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<BillDetail> createBillDetail(@RequestBody BillDetail billDetail){
        billDetailService.createBillDetail(billDetail);
        return new ResponseEntity<>(billDetail, HttpStatus.OK);
    }
}
