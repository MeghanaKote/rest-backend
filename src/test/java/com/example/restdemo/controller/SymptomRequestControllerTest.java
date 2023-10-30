package com.example.restdemo.controller;

import com.example.restdemo.model.Patient;
import com.example.restdemo.model.SymptomRequest;
import com.example.restdemo.repository.PatientRepository;
import com.example.restdemo.repository.SymptomRequestRepository;
import com.example.restdemo.service.SymptomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SymptomRequestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper provides functionality to convert between Java objects and their JSON representation.
    @Autowired
    private ObjectMapper objectMapper;

    // Setting up the expected list of Person objects which the controller should return.
    List<SymptomRequest> expectedSymptom = List.of(
            new SymptomRequest(1L, 2L, "Fever", "Low"),
            new SymptomRequest(2L, 2L, "Cough", "High")

    );
    @Autowired
    private SymptomRequestRepository symptomRequestRepository;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void testGetSymptomsByPatientId() {
        Long symptomId = 1L;
        Long patientId = 2L;
        String symptom = "Cough";
        String severity = "Low";

        // Create a SymptomRequest object using the constructor
        SymptomRequest symptomRequest = new SymptomRequest(symptomId, patientId, symptom, severity);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Check if the fields are set correctly
        assertEquals(symptomId, symptomRequest.getSymptomId());
        assertEquals(patientId, symptomRequest.getPatientId());
        assertEquals(symptom, symptomRequest.getSymptom());
        assertEquals(severity, symptomRequest.getSeverity());

        // Check if the createdDateTime is not null and close to the current date and time
        LocalDateTime createdDateTime = symptomRequest.getCreatedDateTime();
        assertEquals(currentDateTime.getYear(), createdDateTime.getYear());
        assertEquals(currentDateTime.getMonth(), createdDateTime.getMonth());
        assertEquals(currentDateTime.getDayOfMonth(), createdDateTime.getDayOfMonth());
        assertEquals(currentDateTime.getHour(), createdDateTime.getHour());
        assertEquals(currentDateTime.getMinute(), createdDateTime.getMinute());
    }
    @Test
    public void testCreateSymptom() throws Exception {

        SymptomRequest symptomRequest = new SymptomRequest(1L, 2L, "Fever", "Low");
        String symptomRequestJson = objectMapper.writeValueAsString(symptomRequest);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/addSymptom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(symptomRequestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}