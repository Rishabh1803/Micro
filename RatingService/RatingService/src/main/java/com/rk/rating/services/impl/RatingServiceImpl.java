package com.rk.rating.services.impl;

import com.rk.rating.entities.Rating;
import com.rk.rating.repository.RatingRepository;
import com.rk.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public boolean deleteRatingsByUserId(String userId) {
        try{
            ratingRepository.deleteAll(this.getRatingByUserId(userId));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
