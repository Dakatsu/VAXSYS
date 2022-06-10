package com.vaxsys.dto;

import com.vaxsys.entity.Slot;
import com.vaxsys.entity.Vaccine;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AppointmentCreationDto implements Serializable {
    private Slot slot;
    private Vaccine vaccine;

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

}
