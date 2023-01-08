package com.fresher.msa.services.imp;

import com.fresher.msa.entities.Hotel;
import com.fresher.msa.repo.HotelRepository;
import com.fresher.msa.response.HotelResponse;
import com.fresher.msa.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    HotelRepository hotelResp;
    @Override
    public List<Hotel> getAllHotel() {
        return hotelResp.findAll();
    }
    @Override
    public Hotel createHotel(Hotel hotel) {
        hotelResp.save(hotel);
        return hotel;
    }
    @Override
    public HotelResponse findHotelById(Long id) {
        Hotel hotel = hotelResp.findById(id).get();
        HotelResponse hotelResponse = new HotelResponse(hotel);
        return hotelResponse;
    }
}
