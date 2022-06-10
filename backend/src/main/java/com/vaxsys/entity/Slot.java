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

    /**
     * The Vaccine Center which has this open appointment slot.
     */
    @ManyToOne
    @JoinColumn(name="vaccine_center_id", referencedColumnName = "id", nullable=false)
    private VaccineCenter vaccineCenter;

    public Slot(String time, VaccineCenter vaccineCenter) {
        setTime(time);
        setVaccineCenter(vaccineCenter);
        setEnable(true);
    }

    public Slot() {
        this(null, null);
    }

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

    public VaccineCenter getVaccineCenter() {
        return vaccineCenter;
    }

    public void setVaccineCenter(VaccineCenter vaccineCenter) {
        this.vaccineCenter = vaccineCenter;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
