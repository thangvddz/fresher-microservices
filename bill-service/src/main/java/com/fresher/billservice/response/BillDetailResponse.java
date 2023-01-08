package com.fresher.billservice.response;
import lombok.Data;

import java.util.Date;

@Data
public class BillDetailResponse {
    private BillResponse billResponse;
    private CustomerResponse customerResponse;
    private RoomResponse roomResponse;
    private Date checkIn;
    private Date checkOut;
    private int dayIn;
    private String totalTime;
    private Double amountMoney;
    private boolean status;
}
