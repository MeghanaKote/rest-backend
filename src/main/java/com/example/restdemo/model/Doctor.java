package com.example.restdemo.model;

public class Doctor
{
    private Long doctorId;
    private String patientName;
    private String condition;
    private String medication;
    private String doctorName;
    private String dateOfVisit;
    public void Doctor() {
    }

    public Doctor(String patientName, String condition, String medication, String doctorName, String dateOfVisit) {
        this.patientName = patientName;
        this.condition = condition;
        this.medication = medication;
        this.doctorName = doctorName;
        this.dateOfVisit = dateOfVisit;
    }

    public Long getId() {
        return doctorId;
    }

    public void setId(Long id) {
        this.doctorId = doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
}

