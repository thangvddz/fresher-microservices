package com.fresher.msa.response;

import com.fresher.msa.entities.RoomHotel;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RoomResponse {

    private String numberRoom;
    private int floor;
    private TypeRoomResponse typeRoomResponse;
    private HotelResponse hotelResponse;
    public RoomResponse(RoomHotel roomHotel){
        this.numberRoom = roomHotel.getNumberRoom();
        this.floor = roomHotel.getFloor();
    }
}
