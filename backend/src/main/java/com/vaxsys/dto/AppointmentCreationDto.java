package com.vaxsys.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AppointmentCreationDto implements Serializable {
    private Integer vaccineCenterId;
    private Integer vaccineId;
    private String time;

    public Integer getVaccineCenterId() {
        return vaccineCenterId;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public String getTime() {
        return time;
    }

}
