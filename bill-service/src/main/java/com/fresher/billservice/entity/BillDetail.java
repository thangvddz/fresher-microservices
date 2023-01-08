package com.fresher.billservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "bill_detail")
@Data
public class BillDetail {
    @Id
    private Long idBillDetail;
    @Column(name = "id_bill")
    private Long idBill;
    @Column(name = "id_customer")
    private Long idCustomer;
    @Column(name = "id_room")
    private Long idRoom;
    @Column(name = "check_in", columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Column(name = "check_out", columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @Column(name = "total_time")
    private String totalTime;
    @Column(name = "day_in")
    private int dayIn;
    @Column(name = "amount_money")
    private Double amountMoney;
    @Column(name = "status")
    private Boolean status;
}
