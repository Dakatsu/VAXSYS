package com.vaxsys.dto;

import java.io.Serializable;
import java.util.Objects;

public class SlotDto implements Serializable {
    private String time;

    private VaccineCenterDto vaccineCenter;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public VaccineCenterDto getVaccineCenter() {
        return vaccineCenter;
    }

    public void setVaccineCenter(VaccineCenterDto vaccineCenter) {
        this.vaccineCenter = vaccineCenter;
    }
}
