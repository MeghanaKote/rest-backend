package com.example.restdemo.controller;

import com.example.restdemo.model.SymptomRequest;
import com.example.restdemo.repository.PatientRepository;
import com.example.restdemo.repository.SymptomRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SymptomRequestController {

    @Autowired
    private SymptomRequestRepository symptomRequestRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/addSymptom")
    public ResponseEntity<SymptomRequest> createSymptom(@RequestBody SymptomRequest symptomRequest){

        SymptomRequest savedPatient = symptomRequestRepository.save(symptomRequest);

        return ResponseEntity.ok(symptomRequest);
    }
}
