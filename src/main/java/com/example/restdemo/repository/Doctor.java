package com.example.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Doctor extends JpaRepository<Doctor, Long> {
}
