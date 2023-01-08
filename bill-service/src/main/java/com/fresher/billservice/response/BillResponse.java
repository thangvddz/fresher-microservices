package com.fresher.billservice.response;

import com.fresher.billservice.entity.Bill;
import com.fresher.billservice.entity.BillDetail;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.*;

@Data
public class BillResponse {
    private String name;
    private Date timeStamp;
    private Double price;
    private boolean status;
    private Map<Long, List<BillDetailResponse>> mapBillDetail = new HashMap<>();

    public BillResponse(Bill bill){
        this.name = bill.getName();
        this.timeStamp = bill.getTimeStamp();
        this.price = bill.getPrice();
        this.status= bill.isStatus();
    }
}
