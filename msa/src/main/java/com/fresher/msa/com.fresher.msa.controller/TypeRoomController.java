package com.fresher.msa.com.fresher.msa.controller;

import com.fresher.msa.entities.RoomHotel;
import com.fresher.msa.entities.TypeRoom;
import com.fresher.msa.services.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeRoom")
public class TypeRoomController {
    @Autowired
    TypeRoomService typeRoomService;

    @GetMapping("/getAllTypeRoom")
    public ResponseEntity<List<TypeRoom>> getAllRoom(){
        return new ResponseEntity<>(typeRoomService.getAllTypeRoom(), HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<TypeRoom> addRoom(@RequestBody TypeRoom roomHotel){
        typeRoomService.createTypeRoom(roomHotel);
        return new ResponseEntity<>(roomHotel, HttpStatus.OK);
    }
}
