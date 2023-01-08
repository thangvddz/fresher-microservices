package com.fresher.msa.services;

import com.fresher.msa.entities.RoomHotel;
import com.fresher.msa.response.RoomResponse;
import com.fresher.msa.response.TypeRoomResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {
    List<RoomHotel> getAllRoom();
    RoomHotel addRoom(RoomHotel roomHotel);

    RoomHotel updateStatusRoomIsNotEmpty(Long id);
    RoomHotel updateStatusRoomIsEmpty(Long id);
    RoomHotel updateRoom(RoomHotel roomHotel);
    RoomResponse findRoomById(Long id);

    TypeRoomResponse findTypeRoomById(Long idTypeRoom);
    List<RoomHotel> getAllEmptyRoom();
    List<RoomHotel> getAllRoomRent();
}
