package com.fresher.billdetailservice.response;

import lombok.Data;

@Data
public class RoomResponse {

    private int id;
    private String numberRoom;
    private int floor;
    private int idTypeRoom;
    private TypeRoomResponse typeRoomResponse;

//    public RoomResponse(RoomHotel roomHotel){
//        this.id= roomHotel.getId();
//        this.numberRoom = roomHotel.getNumberRoom();
//        this.floor = roomHotel.getFloor();
//        this.idTypeRoom = roomHotel.getIdTypeRoom();
//    }
}