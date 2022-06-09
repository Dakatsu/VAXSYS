package com.vaxsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "dose_required")
    private Integer doseRequired;

    @ManyToOne
    @JoinColumn(name="disease_id", referencedColumnName = "id", nullable=false)
    private Disease disease;

    public Vaccine() {}

    public Vaccine(String name, String description, String instruction, Integer doseRequired, Disease disease) {
        this.name = name;
        this.description = description;
        this.instruction = instruction;
        this.doseRequired = doseRequired;
        this.disease = disease;
    }

    public Integer getId() {
        return id;
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

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
