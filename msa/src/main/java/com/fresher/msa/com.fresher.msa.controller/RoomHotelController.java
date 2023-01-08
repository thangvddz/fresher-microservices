package com.fresher.msa.com.fresher.msa.controller;

import com.fresher.msa.entities.RoomHotel;
import com.fresher.msa.response.RoomResponse;
import com.fresher.msa.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomHotelController {
    @Autowired
    RoomService roomService;

    @GetMapping("/getAllRoom")
    public ResponseEntity<List<RoomHotel>> getAllRoom(){
        return new ResponseEntity<>(roomService.getAllRoom(), HttpStatus.OK);
    }

    @GetMapping("/getAllEmptyRoom")
    public ResponseEntity<List<RoomHotel>> getAllEmptyRoom(){
        return new ResponseEntity<>(roomService.getAllEmptyRoom(), HttpStatus.OK);
    }

    @GetMapping("/getAllRoomRent")
    public ResponseEntity<List<RoomHotel>> getAllRoomRent(){
        return new ResponseEntity<>(roomService.getAllRoomRent(), HttpStatus.OK);
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity<RoomResponse> findRoomById(@PathVariable("id") Long id){
        RoomResponse roomResponse = roomService.findRoomById(id);
        return new ResponseEntity<>(roomResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RoomHotel> addRoom(@RequestBody RoomHotel roomHotel){
        roomService.addRoom(roomHotel);
        return new ResponseEntity<>(roomHotel, HttpStatus.OK);
    }

    @GetMapping("/setStatusInActive")
    public ResponseEntity setStatusRoomInactive(@RequestParam(name = "id") Long id){
         roomService.updateStatusRoomIsNotEmpty(id);
         return ResponseEntity.status(HttpStatus.OK).body("Room is in-active");
    }

    @GetMapping("/setStatusActive")
    public ResponseEntity setStatusRoomActive(@RequestParam(name = "id") Long id){
        roomService.updateStatusRoomIsEmpty(id);
        return ResponseEntity.status(HttpStatus.OK).body("Room is Active");
    }
}
