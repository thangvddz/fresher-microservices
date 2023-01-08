package com.fresher.msa.com.fresher.msa.controller;

import com.fresher.msa.entities.Hotel;
import com.fresher.msa.response.HotelResponse;
import com.fresher.msa.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/getAllHotel")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return new ResponseEntity<>(hotelService.getAllHotel(), HttpStatus.OK);
    }

    @GetMapping("/findHotelById/{id}")
    public ResponseEntity<HotelResponse> findHotelById(@PathVariable(name = "id") Long id){
        HotelResponse hotelResponse = hotelService.findHotelById(id);
        return new ResponseEntity<>(hotelResponse, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Hotel> getAllHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.OK);
    }
}
