package com.vaxsys.dto;

import java.time.LocalDate;

public class AppointmentDto {
    private Integer id;
    private Integer vaccineCenterId;
    private Integer patientId;
    private Integer vaccineId;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVaccineCenterId() {
        return vaccineCenterId;
    }

    public void setVaccineCenterId(Integer vaccineCenterId) {
        this.vaccineCenterId = vaccineCenterId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
