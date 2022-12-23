package com.rk.rating.services;

import com.rk.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);
    List<Rating> getRatings();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
}
