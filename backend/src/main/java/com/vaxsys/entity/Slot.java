package com.vaxsys.entity;

import javax.persistence.*;

@Entity
@Table(name = "slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name = "time")
    private String time;

    @Column(name = "vaccine_center_id")
    private Integer vaccine_center_id;

    @Column(name = "enable")
    private boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getVaccine_center_id() {
        return vaccine_center_id;
    }

    public void setVaccine_center_id(Integer vaccine_center_id) {
        this.vaccine_center_id = vaccine_center_id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
