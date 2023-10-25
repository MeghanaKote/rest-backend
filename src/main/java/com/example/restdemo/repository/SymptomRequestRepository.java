package com.example.restdemo.repository;

import com.example.restdemo.model.SymptomRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymptomRequestRepository extends JpaRepository<SymptomRequest, Long> {

    //List<SymptomRequest> getSymptomsByPatientId(Long patientId);
    List<SymptomRequest> findByPatientId(Long patientId);
}
