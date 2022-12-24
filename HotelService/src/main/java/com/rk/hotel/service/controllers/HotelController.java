package com.rk.hotel.service.controllers;

import com.rk.hotel.service.entities.Hotel;
import com.rk.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity.BodyBuilder deleteHotel(@PathVariable String hotelId){
        boolean deletion = hotelService.deleteHotel(hotelId);
        return ResponseEntity.status(deletion ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
