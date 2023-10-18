package com.example.restdemo.controller;

import com.example.restdemo.model.Users;
import com.example.restdemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UsersController {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/user")
    public List<Users> getAllUsers(){
        return usersRepository.findAll();


    }
}
