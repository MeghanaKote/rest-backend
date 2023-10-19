package com.example.restdemo.controller;


import com.example.restdemo.model.Admin;
import com.example.restdemo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        // Validate the input and handle errors if needed
       /* if (admin.getEmail() == null || admin.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        // Check if an admin with the same email already exists
        if (adminRepository.findAllByEmail(admin.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email is already registered");
        }

        // Save the new admin to the database */


        adminRepository.save(admin);

        return ResponseEntity.ok(admin);


    }
}
