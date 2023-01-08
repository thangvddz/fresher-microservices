package com.fresher.billservice.service.imp;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.entity.BillDetail;
import com.fresher.billservice.feignClients.CustomerFeignClient;
import com.fresher.billservice.feignClients.RoomFeignClient;
import com.fresher.billservice.repo.BillDetailRepository;
import com.fresher.billservice.repo.BillRepo;
import com.fresher.billservice.response.BillDetailResponse;
import com.fresher.billservice.response.BillResponse;
import com.fresher.billservice.response.RoomResponse;
import com.fresher.billservice.service.BillDetailService;
import com.fresher.billservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImp implements BillService {

    @Autowired
    BillRepo billRepo;

    @Autowired
    BillDetailRepository billDetailRepository;

    @Autowired
    RoomFeignClient roomFeignClient;

    @Autowired
    CustomerFeignClient customerFeignClient;

    @Override
    public List<Bill> getAllBill() {
        return billRepo.findAll();
    }

    @Override
    public Bill addBill(Bill bill) {
        billRepo.save(bill);
        return bill;
    }

    @Override
    public Bill disableBill(Long id) {
        Bill bill = billRepo.findById(id).get();
        bill.setStatus(false);
        return bill;
    }

    @Override
    public BillResponse findBillById(Long id) {
        Bill bill = billRepo.findById(id).get();
        BillResponse billResponse = new BillResponse(bill);

        return billResponse;
    }

    @Override
    public Bill findBillNewCreate() {
        return billRepo.findBillByNewCreate();
    }

    @Override
    public BillResponse findDetailResponseById(Long id){
        Bill bill = billRepo.findById(id).get();
        BillResponse billResponse = new BillResponse(bill);
        List<BillDetail> list = billDetailRepository.findBillDetailByIdBill(id);
        List<BillDetailResponse> detailResponseList = new ArrayList<>();
        list.stream().forEach(billDetail -> {
            BillDetailResponse detailResponse = new BillDetailResponse();
            RoomResponse roomResponse = roomFeignClient.getByIdRoom(billDetail.getIdRoom());
            detailResponse.setCustomerResponse(customerFeignClient.findById(billDetail.getIdCustomer()));
            detailResponse.setRoomResponse(roomResponse);
            detailResponse.setCheckIn(billDetail.getCheckIn());
            detailResponse.setCheckOut(billDetail.getCheckOut());
            detailResponse.setAmountMoney(billDetail.getAmountMoney());
            detailResponse.setTotalTime(billDetail.getTotalTime());
            detailResponse.setStatus(billDetail.getStatus());
            detailResponse.setDayIn(0);
            detailResponseList.add(detailResponse);
        });
        Map<Long, List<BillDetailResponse>> mapBillDetail = new HashMap<>();
        mapBillDetail.put(bill.getIdBill(), detailResponseList);
        billResponse.setMapBillDetail(mapBillDetail);
        return billResponse;
    }

}
