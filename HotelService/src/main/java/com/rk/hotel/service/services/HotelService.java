package com.rk.hotel.service.services;

import com.rk.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(String id);
}
