package com.example.restdemo.repository;

import com.example.restdemo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findAllByEmail(String email);
}
