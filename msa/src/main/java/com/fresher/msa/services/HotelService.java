package com.fresher.msa.services;

import com.fresher.msa.entities.Hotel;
import com.fresher.msa.response.HotelResponse;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotel();
    Hotel createHotel(Hotel hotel);

    HotelResponse findHotelById(Long id);
}
