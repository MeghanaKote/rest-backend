package com.example.restdemo.controller;

import com.example.restdemo.model.Patient;
import com.example.restdemo.model.SymptomRequest;
import com.example.restdemo.repository.PatientRepository;
import com.example.restdemo.repository.SymptomRequestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
            new SymptomRequest(1L,2L,"Fever","Low"),
            new SymptomRequest(2L,2L,"Cough","High")

    );
    @Autowired
    private SymptomRequestRepository symptomRequestRepository;
    @BeforeEach
    public void setup() {}

    @Test
    public void testGetSymptomsByPatientId() throws Exception{
        Long patientId = 2L;
        symptomRequestRepository.saveAll(expectedSymptom);
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedSymptom);


        mockMvc.perform(get("/getSymptom")
                .param("patientId", String.valueOf(patientId)))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }
//    @Test
//    public void testCreateSymptom() throws Exception {
//        SymptomRequest request = new SymptomRequest(); // Create a SymptomRequest object for testing
//        request.setSymptom("Test Symptom"); // Set relevant data for testing
//
//        // Configure the behavior of your mock repository
//        when(symptomRequestRepository.save(request)).thenReturn(request);
//
//        mockMvc.perform(post("/addSymptom")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(new ObjectMapper().writeValueAsString(request)))
//                .andExpect(status().isOk());
//
//        // Add more assertions as needed
//    }



}