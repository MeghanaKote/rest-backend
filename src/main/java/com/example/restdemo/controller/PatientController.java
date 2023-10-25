package com.example.restdemo.controller;

import com.example.restdemo.model.Patient;
import com.example.restdemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

    @GetMapping("/bookAppointment")
    public ResponseEntity<String> serveHtmlPage() {
        Resource resource = new ClassPathResource("static/BookAppointment.html");

        try {
            InputStream inputStream = resource.getInputStream();
            byte[] htmlBytes = FileCopyUtils.copyToByteArray(inputStream);
            String htmlContent = new String(htmlBytes, StandardCharsets.UTF_8);

            return ResponseEntity.ok(htmlContent);
        } catch (IOException e) {
            // Handle the exception appropriately (e.g., return an error response)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error loading HTML content");
        }
    }
}
