package com.example.restdemo.controllerTest;


import com.example.restdemo.model.Users;
import com.example.restdemo.repository.UsersRepository;
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
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsersRepository usersRepository;

    List<Users> expectedUser = List.of(
            new Users(1L,"Doctor","Shan","Shan@123"),
            new Users(2L,"Patient","Jimmy","Jimmy@123"),
            new Users(3L,"Admin","Paul","Paul@123")
    );

    @BeforeEach
    public void setup(){}


    @Test
    public void testGetAllUsers() throws Exception {
        usersRepository.saveAll(expectedUser);
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedUser);
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }




}
