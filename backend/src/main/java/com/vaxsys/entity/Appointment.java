package com.vaxsys.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name = "vaccine_center_id")
    private Integer vaccineCenterId;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "vaccine_id")
    private Integer vaccineId;

    @Column(name = "time")
    private String time;

    public Appointment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getVaccineCenterId() {
        return vaccineCenterId;
    }

    public void setVaccineCenterId(Integer vaccineCenterId) {
        this.vaccineCenterId = vaccineCenterId;
    }

    public Appointment(Integer vaccineCenterId, Integer patientId, Integer vaccineId, String time) {
        this.vaccineCenterId = vaccineCenterId;
        this.patientId = patientId;
        this.vaccineId = vaccineId;
        this.time = time;
    }
}
