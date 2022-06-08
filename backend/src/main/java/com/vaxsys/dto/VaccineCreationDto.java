package com.vaxsys.dto;

import com.vaxsys.entity.Disease;

public class VaccineCreationDto {

    private String name;
    private String description;
    private Disease disease;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
