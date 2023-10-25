package com.example.restdemo.controller;

import com.example.restdemo.model.Patient;
import com.example.restdemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {

        return patientRepository.findAll();
    }

    @PostMapping("/addPatient")

    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {

        // Save the patient entity using the repository

        Patient savedPatient = patientRepository.save(patient);

        return ResponseEntity.ok(patient);

    }
}
