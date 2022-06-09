package com.vaxsys.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy="disease")
    private Set<Vaccine> vaccines;

    public Disease() {
    }

    public Disease(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Vaccine> getVaccines() {
        return vaccines;
    }

}
