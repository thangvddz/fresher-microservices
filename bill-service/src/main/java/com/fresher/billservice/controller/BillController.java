package com.fresher.billservice.controller;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.response.BillResponse;
import com.fresher.billservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/getAllBill")
    public ResponseEntity<List<Bill>> getAllBill(){
        return new ResponseEntity<>(billService.getAllBill(), HttpStatus.OK);
    }

    @GetMapping("/findBillById/{id}")
    public ResponseEntity<BillResponse> findBillById(@PathVariable(name = "id") Long id){
        BillResponse billResponse = billService.findBillById(id);
        return new ResponseEntity<>(billResponse, HttpStatus.OK);
    }

    @GetMapping("/findBillNewCreate")
    public Bill findBillNewCreate(){
        Bill billResponse = billService.findBillNewCreate();
        return billResponse;
    }

    @GetMapping("/findBillFromBillDetail/{id}")
    public ResponseEntity<BillResponse> findBillFromBillDetail(@PathVariable(name = "id") Long id_bill){
        BillResponse billResponse = billService.findDetailResponseById(id_bill);
        return new ResponseEntity<>(billResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        billService.addBill(bill);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
}
