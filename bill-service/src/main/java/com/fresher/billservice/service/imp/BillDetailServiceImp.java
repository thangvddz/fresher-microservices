package com.fresher.billservice.service.imp;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.entity.BillDetail;
import com.fresher.billservice.feignClients.CustomerFeignClient;
import com.fresher.billservice.feignClients.RoomFeignClient;
import com.fresher.billservice.repo.BillDetailRepository;
import com.fresher.billservice.response.BillDetailResponse;
import com.fresher.billservice.repo.BillDetailRepository;
import com.fresher.billservice.response.CustomerResponeId;
import com.fresher.billservice.response.CustomerResponse;
import com.fresher.billservice.response.RoomResponse;
import com.fresher.billservice.service.BillDetailService;
import com.fresher.billservice.service.BillService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BillDetailServiceImp implements BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;

    @Autowired
    BillService billService;

    @Autowired
    RoomFeignClient roomFeignClient;

    @Autowired
    CustomerFeignClient customerFeignClient;

    @Override
    public List<BillDetailResponse> getBillDetailAll() {
        List<BillDetailResponse> listAllBillDetail = new ArrayList<>();
        billDetailRepository.findAll().stream().forEach(billDetail ->
        {
            BillDetailResponse detailResponse = new BillDetailResponse();
            RoomResponse roomResponse = roomFeignClient.getByIdRoom(billDetail.getIdRoom());
            detailResponse.setCustomerResponse(customerFeignClient.findById(billDetail.getIdCustomer()));
            detailResponse.setBillResponse(billService.findBillById(billDetail.getIdBill()));
            detailResponse.setRoomResponse(roomResponse);
            detailResponse.setCheckIn(billDetail.getCheckIn());
            detailResponse.setCheckOut(billDetail.getCheckOut());
            detailResponse.setAmountMoney(billDetail.getAmountMoney());
            detailResponse.setTotalTime(billDetail.getTotalTime());
            detailResponse.setStatus(billDetail.getStatus());
            detailResponse.setDayIn(billDetail.getDayIn());
            listAllBillDetail.add(detailResponse);
        });
        return listAllBillDetail;
    }

    @Override
    public List<BillDetail> getBillDetailRawAll() {
        return billDetailRepository.findAll();
    }

    @Override
    public BillDetail createBillDetail(BillDetail billDetail) {
        Date date = Calendar.getInstance(TimeZone.getDefault()).getTime();
        billDetail.setCheckIn(date);
        billDetailRepository.save(billDetail);
        roomFeignClient.setStatusRoomInactive(billDetail.getIdRoom());
        return billDetail;
    }

    @Override
    public BillDetail findBillDetail(Long id) {
        BillDetail detail = billDetailRepository.findById(id).get();
        return detail;
    }

    @Override
    public Map<Long, List<BillDetailResponse>> findBillDetailByPhoneNumber(String phoneNumber) {
        List<CustomerResponeId> ls = customerFeignClient.findCustomerByNumberPhone(phoneNumber);
        Map<Long, List<BillDetailResponse>> map = new HashMap<>();
        ls.stream().forEach(customerResponeId -> {
            List<BillDetail> billDetails = billDetailRepository.findBillDetailByIdCustomer(customerResponeId.getIdCustomer());
            List<BillDetailResponse> billDetailResponseList = new ArrayList<>();
            billDetails.stream().forEach(billDetail -> {
                BillDetailResponse detailResponse = new BillDetailResponse();
                RoomResponse roomResponse = roomFeignClient.getByIdRoom(billDetail.getIdRoom());
                detailResponse.setCustomerResponse(getCutomerResponseById(billDetail.getIdCustomer()));
                detailResponse.setBillResponse(billService.findBillById(billDetail.getIdBill()));
                detailResponse.setRoomResponse(roomResponse);
                detailResponse.setCheckIn(billDetail.getCheckIn());
                detailResponse.setCheckOut(billDetail.getCheckOut());
                detailResponse.setAmountMoney(billDetail.getAmountMoney());
                detailResponse.setTotalTime(billDetail.getTotalTime());
                detailResponse.setStatus(billDetail.getStatus());
                billDetailResponseList.add(detailResponse);
            });
            map.put(customerResponeId.getIdCustomer(), billDetailResponseList);
        });
        return map;
    }

    @CircuitBreaker(name = "customerService",
            fallbackMethod = "fallBackCutomerById")
    public CustomerResponse getCutomerResponseById(Long idCustomer){
        return customerFeignClient.findById(idCustomer);
    }

    public CustomerResponse fallBackCutomerById(Long idCustomer, Throwable th){
        log.info("Error in fallback: {}", th);
        return new CustomerResponse();
    }

    @Override
    public List<BillDetail> findBillDetailByIdCustomer(Long id) {
        List<BillDetail> list = billDetailRepository.findBillDetailByIdCustomer(id);
        return list;
    }

    @Override
    public List<BillDetail> findBillDetailByIdRoom(Long id) {
        List<BillDetail> list = billDetailRepository.findBillDetailByIdRoom(id);
        return list;
    }

    @Override
    public List<BillDetail> findBillDetailByIdBill(Long idBill) {
        List<BillDetail> list = billDetailRepository.findBillDetailByIdBill(idBill);
        return list;
    }

    /*
    * check out:
    * 1.get id room,
    * 2.get billdetail by id room,
    * 3. set check out date is now, set status bill detail is false and finally save that
    * 4. setting status room active is false
    * */
    @Override
    public BillDetail checkOut(Long id) {
        BillDetail billDetail = billDetailRepository.setCheckOutForBillDetail(id);
        Date date = Calendar.getInstance(TimeZone.getDefault()).getTime();
        billDetail.setCheckOut(date);
        billDetail.setStatus(false);
        billDetailRepository.save(billDetail);
        roomFeignClient.setStatusRoomActive(id);
        return billDetail;
    }

    @Override
    public boolean isEmptyRoom(Long idRoom) {
        BillDetail billDetail = billDetailRepository.checkEmptyRoom(idRoom);
        if (billDetail != null){
            // room available
            return false;
        }
        // room empty
        return true;
    }
}
