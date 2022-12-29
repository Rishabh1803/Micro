package com.rk.config.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CheckController {

    @GetMapping
    public String checkFunction(){
        return "Config Server Service is running!";
    }
}
