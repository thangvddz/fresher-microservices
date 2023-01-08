package com.fresher.msa.services.imp;

import com.fresher.msa.entities.RoomHotel;
import com.fresher.msa.entities.TypeRoom;
import com.fresher.msa.repo.RoomRepository;
import com.fresher.msa.repo.TypeRoomRepository;
import com.fresher.msa.response.HotelResponse;
import com.fresher.msa.response.RoomResponse;
import com.fresher.msa.response.TypeRoomResponse;
import com.fresher.msa.services.HotelService;
import com.fresher.msa.services.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class RoomServiceImp implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    WebClient webClient;

    @Override
    public List<RoomHotel> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public RoomHotel addRoom(RoomHotel roomHotel) {
        roomRepository.save(roomHotel);
        return roomHotel;
    }

    @Override
    public RoomHotel updateStatusRoomIsNotEmpty(Long id) {
        //phong chua thue status = false
        RoomHotel roomHotel = roomRepository.findById(id).get();
        if (roomHotel != null){
            roomHotel.setStatus(true);
            roomRepository.save(roomHotel);
        }
        return null;
    }

    @Override
    public RoomHotel updateStatusRoomIsEmpty(Long id) {
        // phong da thue co status = true
        RoomHotel roomHotel = roomRepository.findById(id).get();
        if (roomHotel != null){
            roomHotel.setStatus(false);
            roomRepository.save(roomHotel);
        }
        return null;
    }

    @Override
    public RoomHotel updateRoom(RoomHotel roomHotel) {
        roomRepository.save(roomHotel);
        return roomHotel;
    }

    @Override
    public RoomResponse findRoomById(Long id) {
        log.info("room id ih: {}", id);
        RoomHotel roomHotel = roomRepository.findById(id).get();
        RoomResponse roomResponse1 = new RoomResponse(roomHotel);
        TypeRoomResponse typeRoomResponse = findTypeRoomById((long) roomHotel.getIdTypeRoom());
        HotelResponse hotelResponse = hotelService.findHotelById(roomHotel.getIdHotel());
        roomResponse1.setTypeRoomResponse(typeRoomResponse);
        roomResponse1.setHotelResponse(hotelResponse);
        return roomResponse1;
    }

    @Override
    public TypeRoomResponse findTypeRoomById(Long idTypeRoom){
//        Mono<TypeRoomResponse> typeRoomResponseMono = webClient.get().uri("/findByID/"+idTypeRoom).retrieve().bodyToMono(TypeRoomResponse.class);
        TypeRoom typeRoom = typeRoomRepository.findById(idTypeRoom).get();
        TypeRoomResponse typeRoomResponse = new TypeRoomResponse(typeRoom);
        return typeRoomResponse;
    }

    @Override
    public List<RoomHotel> getAllEmptyRoom() {
        return roomRepository.getAllEmptyRoom();
    }

    @Override
    public List<RoomHotel> getAllRoomRent() {
        return roomRepository.getAllRoomRent();
    }
}
