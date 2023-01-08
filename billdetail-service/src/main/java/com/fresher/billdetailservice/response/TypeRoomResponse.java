package com.fresher.billdetailservice.response;

import com.fresher.billdetailservice.response.TypeRoomResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeRoomResponse {

    private int id;
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
