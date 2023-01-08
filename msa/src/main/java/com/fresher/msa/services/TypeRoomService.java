package com.fresher.msa.services;

import com.fresher.msa.entities.TypeRoom;

import java.util.List;

public interface TypeRoomService {
    List<TypeRoom> getAllTypeRoom();
    TypeRoom createTypeRoom(TypeRoom typeRoom);
}
