package com.vaxsys.dto;

import com.vaxsys.entity.VaccineCenter;

public class SlotCreationDto {

    private String time;

    private VaccineCenter vaccineCenter;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public VaccineCenter getVaccineCenter() {
        return vaccineCenter;
    }

    public void setVaccineCenter(VaccineCenter vaccineCenter) {
        this.vaccineCenter = vaccineCenter;
    }
}
