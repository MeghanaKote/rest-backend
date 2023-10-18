package com.example.restdemo.controller;

import com.example.restdemo.model.Patient;
import com.example.restdemo.repository.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    // MockMvc provides a way to test Spring MVC controllers by sending HTTP requests into the DispatcherServlet
    // and asserting the response details.
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper provides functionality to convert between Java objects and their JSON representation.
    @Autowired
    private ObjectMapper objectMapper;

    // Setting up the expected list of Person objects which the controller should return.
    List<Patient> expectedPatient = List.of(
            new Patient(1L,"Smith","K",10,"10-24-1993","male","95641234562","smith.a@gmail.com","Dublin"),
            new Patient(2L,"Raj","M",10,"10-24-1990","male","95641234552","raj.a@gmail.com","Dublin")

    );

    // PersonRepository - we will use it
    //  to save Person objects
    //  from the expectedPeople List
    //  to DB
    //  before calling the endpoint
    @Autowired
    private PatientRepository patientRepository;

    // Before each test method is run, this setup method will be invoked.
    // As of now, it's empty, but you can add any initial setup for your tests here.
    @BeforeEach
    public void setup() {}

    // The Test annotation indicates that this method is a test method.
    @Test
    public void testGetAllPatient() throws Exception {
        // Save the objects to DB
        patientRepository.saveAll(expectedPatient);

        // Converting the expected list of people to a JSON string.
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedPatient);

        // Using mockMvc to perform an HTTP GET request to /people
        mockMvc.perform(get("/patient"))
                // Expecting the HTTP status to be 200 OK
                .andExpect(status().isOk())
                // Expecting the response body to be the JSON representation of the expected list of people.
                .andExpect(content().json(expectedJsonResponse));
    }
}
