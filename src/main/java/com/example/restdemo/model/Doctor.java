package com.example.restdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long DoctorId;
    private  String DoctorName;
    private Long DoctorPhoneNo;
    private String DoctorEmailId;
    private String DoctorAddress;
    private String DoctorDept;


    public Doctor(Long doctorId, String doctorName, Long doctorPhoneNo, String doctorEmailId, String doctorAddress, String doctorDept) {
        DoctorId = doctorId;
        DoctorName = doctorName;
        DoctorPhoneNo = doctorPhoneNo;
        DoctorEmailId = doctorEmailId;
        DoctorAddress = doctorAddress;
        DoctorDept = doctorDept;
    }

    public Doctor(Long doctorId) {
        DoctorId = doctorId;
    }

    public Doctor() {
    }

    public Long getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(Long doctorId) {
        DoctorId = doctorId;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public Long getDoctorPhoneNo() {
        return DoctorPhoneNo;
    }

    public void setDoctorPhoneNo(Long doctorPhoneNo) {
        DoctorPhoneNo = doctorPhoneNo;
    }

    public String getDoctorEmailId() {
        return DoctorEmailId;
    }

    public void setDoctorEmailId(String doctorEmailId) {
        DoctorEmailId = doctorEmailId;
    }

    public String getDoctorAddress() {
        return DoctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        DoctorAddress = doctorAddress;
    }

    public String getDoctorDept() {
        return DoctorDept;
    }

    public void setDoctorDept(String doctorDept) {
        DoctorDept = doctorDept;
    }
}
