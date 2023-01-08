package com.fresher.billservice.controller;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.entity.BillDetail;
import com.fresher.billservice.response.BillDetailResponse;
import com.fresher.billservice.service.BillDetailService;
import com.fresher.billservice.service.BillService;
import jakarta.ws.rs.core.MultivaluedMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bill-detail")
@Slf4j
public class BillDetailController {
    @Autowired
    BillDetailService billDetailService;

    @Autowired
    BillService billService;

    @GetMapping("/getAllBillDetail")
    public ResponseEntity<List<BillDetailResponse>> getAllBillDetail(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return new ResponseEntity<>(billDetailService.getBillDetailAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllBillDetailRaw")
    public ResponseEntity<List<BillDetail>> getAllBillDetailDanger(){
        return new ResponseEntity<>(billDetailService.getBillDetailRawAll(), HttpStatus.OK);
    }

    @GetMapping("/check-out/{id}")
    public ResponseEntity<BillDetail> getCheckout(@PathVariable(name = "id") Long idRoom){
        BillDetail billDetail = billDetailService.checkOut(idRoom);
        return new ResponseEntity<>(billDetail, HttpStatus.OK);
    }

    @GetMapping("/check-in")
    public ResponseEntity<BillDetail> getCheckIn(@RequestBody BillDetail billDetail){
        boolean isEmptyRoom = billDetailService.isEmptyRoom(billDetail.getIdRoom());
        if (isEmptyRoom == false){
            log.info("the room is available !");
            return new ResponseEntity<>(billDetail, HttpStatus.OK);
        }

        billDetailService.createBillDetail(billDetail);
        log.info("the room is not available !");

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/create")
    public ResponseEntity<BillDetail> createBillDetail(@RequestBody BillDetail billDetail){
        boolean isEmptyRoom = billDetailService.isEmptyRoom(billDetail.getIdRoom());
        if (isEmptyRoom == false){
            log.info("the room is available !");
            return new ResponseEntity<>(billDetail, HttpStatus.OK);
        }

        billDetailService.createBillDetail(billDetail);
        log.info("the room is not available !");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @GetMapping("/findByNumberPhone")
    public ResponseEntity<Map<Long, List<BillDetailResponse>>> findByNumberPhone(@RequestParam(name = "phone") String phone){
        Map<Long, List<BillDetailResponse>> map = billDetailService.findBillDetailByPhoneNumber(phone);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/findByIdCustomer/{id}")
    public ResponseEntity<List<BillDetail>> findByIdCustomer(@PathVariable(name = "id") Long id){
        List<BillDetail> map = billDetailService.findBillDetailByIdCustomer(id);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/findByIdRoom/{id}")
    public ResponseEntity<List<BillDetail>> findByIdRoom(@PathVariable(name = "id") Long id){
        List<BillDetail> map = billDetailService.findBillDetailByIdRoom(id);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/findByIdBill/{id}")
    public ResponseEntity<List<BillDetail>> findByIdBill(@PathVariable(name = "id") Long id){
        List<BillDetail> map = billDetailService.findBillDetailByIdBill(id);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
