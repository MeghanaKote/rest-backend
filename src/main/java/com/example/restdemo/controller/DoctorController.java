package com.example.restdemo.controller;

import com.example.restdemo.model.Doctor;
import com.example.restdemo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctor")
    public List<Doctor> expectedDoctor() {

        return doctorRepository.findAll();
    }
}