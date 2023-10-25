package com.example.restdemo.controller;

import com.example.restdemo.model.SymptomRequest;
import com.example.restdemo.repository.PatientRepository;
import com.example.restdemo.repository.SymptomRequestRepository;
import com.example.restdemo.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class SymptomRequestController {

    @Autowired
    private SymptomRequestRepository symptomRequestRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/addSymptom")
    public ResponseEntity<SymptomRequest> createSymptom(@RequestBody SymptomRequest symptomRequest) {

        SymptomRequest savedPatient = symptomRequestRepository.save(symptomRequest);

        return ResponseEntity.ok(symptomRequest);
    }

    @Autowired
    private SymptomService symptomService;

    @GetMapping("/symptom-history")
    public ResponseEntity<String> serveHtmlPage() {
        Resource resource = new ClassPathResource("static/symptom-history.html");

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

    @GetMapping("/getSymptom")
    public List<SymptomRequest> getSymptomsByPatientId(@RequestParam("patientId") Long patientId) {
        // Use the patientId to retrieve symptoms from your service
        List<SymptomRequest> symptoms = symptomService.getSymptomsByPatientId(patientId);
        return symptoms;
        //return "symptom-list"; // Replace with the name of your view template
    }

}
