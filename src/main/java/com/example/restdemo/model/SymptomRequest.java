package com.example.restdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SymptomRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long symptomId;

    private Long patientId;

    private String symptom;

    private String severity;

    public SymptomRequest() {
    }

    public Long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public SymptomRequest(Long symptomId, Long patientId, String symptom, String severity) {
        this.symptomId = symptomId;
        this.patientId = patientId;
        this.symptom = symptom;
        this.severity = severity;
    }
}
