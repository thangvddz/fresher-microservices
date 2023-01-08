package com.fresher.billdetailservice.response;
import lombok.Data;

import java.util.Date;

@Data
public class BillDetailResponse {
    private Long idBillDetail;
    private Long idBill;
    private Long idCustomer;
    private RoomResponse roomResponse;
    private Date checkIn;
    private Date checkOut;
    private String totalTime;
    private Double amountMoney;
}
