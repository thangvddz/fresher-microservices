package com.fresher.paymentservice.controller;

import com.fresher.paymentservice.utils.TimeHotelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/utils")
public class UtilsController {
    @Autowired
    TimeHotelUtils timeHotelUtils;

    @GetMapping("/getTimeInHotel")
    public ResponseEntity<Date> getTimeInHotel(@RequestParam(name = "checkIn") String checkIn,
                                               @RequestParam(name = "checkOut") String checkOut) throws Exception{
        Date checkInDate = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").parse(checkIn);
        Date checkOutDate = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").parse(checkOut);
        return new ResponseEntity<>(timeHotelUtils.timeInHotel(checkInDate, checkOutDate), HttpStatus.OK);
    }
}
