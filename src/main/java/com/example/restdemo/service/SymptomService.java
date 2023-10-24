package com.example.restdemo.service;


import com.example.restdemo.model.SymptomRequest;
import com.example.restdemo.repository.SymptomRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {
    //private final SymptomRequestRepository symptomRequestRepository;


//    @Autowired
//    public SymptomService(SymptomRequestRepository symptomRequestRepository) {
//        this.symptomRequestRepository = symptomRequestRepository;
//    }
//
//    public List<SymptomRequest> getSymptomsByPatientId(Long patientId) {
//        return symptomRequestRepository.getSymptomsByPatientId(patientId);
//    }
@Autowired
private  SymptomRequestRepository symptomRequestRepository;
    public List<SymptomRequest> getSymptomsByPatientId(Long patientId) {
        return symptomRequestRepository.findByPatientId(patientId);
    }

}
