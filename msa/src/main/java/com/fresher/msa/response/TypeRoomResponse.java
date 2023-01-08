package com.fresher.msa.response;

import com.fresher.msa.entities.TypeRoom;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeRoomResponse {

    private String name;
    private boolean status;
    private double price;

    public TypeRoomResponse(TypeRoom typeRoom){
        this.name=typeRoom.getName();
        this.status=typeRoom.isStatus();
        this.price=typeRoom.getPrice();
    }
}
