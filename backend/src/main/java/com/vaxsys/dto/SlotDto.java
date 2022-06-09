package com.vaxsys.dto;

import java.io.Serializable;
import java.util.Objects;

public class SlotDto implements Serializable {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
