package com.rk.user.service.services;

import com.rk.user.service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(String userId);
    boolean deleteUser(String userId);
    //TODO: delete
    //TODO: update
}
