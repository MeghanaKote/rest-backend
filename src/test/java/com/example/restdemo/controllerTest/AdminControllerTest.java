package com.example.restdemo.controllerTest;

import com.example.restdemo.model.Admin;
import com.example.restdemo.repository.AdminRepository;
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
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AdminRepository adminRepository;

    List<Admin> expectedAdmin = List.of(
            new Admin(1L,"John","Doe","john@gmail.com",83674833L),
            new Admin(2L,"Tina","Joe","tina@gmail.com",847637633L),
            new Admin(3L,"Gary","Paul","gary@gmail.com",87645290L)
    );

    @BeforeEach
    public void setup(){}


    @Test
    public void testGetAllAdmins() throws Exception {
        adminRepository.saveAll(expectedAdmin);
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedAdmin);
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }




}
