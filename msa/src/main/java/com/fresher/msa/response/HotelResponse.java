package com.fresher.msa.response;

import com.fresher.msa.entities.Hotel;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class HotelResponse {
    private String nameHotel;
    private Boolean status;
    private Date timeCheckInDefault;
    private Date timeCheckOutDefault;

    public HotelResponse(Hotel hotel){
        this.nameHotel = hotel.getNameHotel();
        this.status = hotel.getStatus();
        this.timeCheckInDefault = hotel.getTimeCheckInDefault();
        this.timeCheckOutDefault = hotel.getTimeCheckOutDefault();
    }
}
