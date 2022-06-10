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

    @OneToOne
    @JoinColumn(name="slot_id", referencedColumnName = "id", nullable=false)
    private Slot slot;

    @ManyToOne
    @JoinColumn(name="patient_id", referencedColumnName = "id", nullable=false)
    private Account patient;

    @ManyToOne
    @JoinColumn(name="vaccine_id", referencedColumnName = "id", nullable=false)
    private Vaccine vaccine;

    @Column(name = "status")
    private Integer status;

    public Appointment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccineId) {
        this.vaccine = vaccine;
    }

    public Account getPatient() {
        return patient;
    }

    public void setPatient(Account patient) {
        this.patient = patient;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Integer vaccineCenterId) {
        this.slot = slot;
    }

    public Appointment(Slot slot, Account patient, Vaccine vaccine, Integer status) {
        this.slot = slot;
        this.patient = patient;
        this.vaccine = vaccine;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
