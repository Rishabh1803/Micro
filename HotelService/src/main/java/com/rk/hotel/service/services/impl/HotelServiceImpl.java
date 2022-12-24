package com.rk.hotel.service.services.impl;

import com.rk.hotel.service.entities.Hotel;
import com.rk.hotel.service.exceptions.ResourceNotFoundException;
import com.rk.hotel.service.repositories.HotelRepository;
import com.rk.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found: " + id));
    }

    @Override
    public boolean deleteHotel(String hotelId) {
        try{
            hotelRepository.delete(this.get(hotelId));
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
