package com.rk.user.service.services.impl;

import com.rk.user.service.entities.Hotel;
import com.rk.user.service.entities.Rating;
import com.rk.user.service.entities.User;
import com.rk.user.service.exceptions.ResourceNotFoundException;
import com.rk.user.service.external.services.HotelService;
import com.rk.user.service.repositories.UserRepository;
import com.rk.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setRatings(restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), ArrayList.class)));
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found: " + userId));
        //Fetch rating of the user from RATING_SERVICE
        //http://localhost:8083/ratings/users/{userId}
        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

        List<Rating> ratingList = ratings.stream().peek(rating -> {
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        }).toList();

        logger.info("{}", ratingList);
        user.setRatings(ratingList);
        return user;
    }
}
