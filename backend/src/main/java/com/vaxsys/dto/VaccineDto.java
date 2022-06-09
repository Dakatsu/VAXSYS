package com.vaxsys.dto;

public class VaccineDto {
    private Integer id;
    private String name;
    private String description;
    private String instruction;
    private Integer doseRequired;
    private DiseaseDto disease;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getDoseRequired() {
        return doseRequired;
    }

    public void setDoseRequired(Integer doseRequired) {
        this.doseRequired = doseRequired;
    }

    public DiseaseDto getDisease() {
        return disease;
    }

    public void setDisease(DiseaseDto disease) {
        this.disease = disease;
    }
}
