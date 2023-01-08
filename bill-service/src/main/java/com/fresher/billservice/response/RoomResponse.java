package com.fresher.billservice.response;

import lombok.Data;

@Data
public class RoomResponse {

    private String numberRoom;
    private int floor;
    private TypeRoomResponse typeRoomResponse;

    private HotelResponse hotelResponse;

//    public RoomResponse(RoomHotel roomHotel){
//        this.id= roomHotel.getId();
//        this.numberRoom = roomHotel.getNumberRoom();
//        this.floor = roomHotel.getFloor();
//        this.idTypeRoom = roomHotel.getIdTypeRoom();
//    }
}