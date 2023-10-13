package com.example.restdemo.controller;

import com.example.restdemo.model.User;
import com.example.restdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userRepository.findAll();


    }
}
