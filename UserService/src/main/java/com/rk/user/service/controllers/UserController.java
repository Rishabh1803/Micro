package com.rk.user.service.controllers;

import com.rk.user.service.entities.User;
import com.rk.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity.BodyBuilder deleteUser(@PathVariable String userId){
        boolean deletion = userService.deleteUser(userId);
        return ResponseEntity.status(deletion ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
