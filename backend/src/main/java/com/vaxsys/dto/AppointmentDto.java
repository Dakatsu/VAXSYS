package com.vaxsys.dto;

import com.vaxsys.entity.Account;
import com.vaxsys.entity.Slot;
import com.vaxsys.entity.Vaccine;

import java.time.LocalDate;

public class AppointmentDto {
    private Integer id;
    private Slot slot;
    private Account patient;
    private Vaccine vaccine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Account getPatient() {
        return patient;
    }

    public void setPatient(Account patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
