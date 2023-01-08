package com.fresher.billservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeRoomResponse {

    private String name;
    private boolean status;
    private double price;

//    public TypeRoomResponse(TypeRoom typeRoom){
//        this.id=typeRoom.getId();
//        this.name=typeRoom.getName();
//        this.status=typeRoom.isStatus();
//        this.price=typeRoom.getPrice();
//    }
}
