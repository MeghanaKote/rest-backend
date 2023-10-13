package com.example.restdemo.controller;

import com.example.restdemo.model.Admin;
import com.example.restdemo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin")
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();

    }

}
