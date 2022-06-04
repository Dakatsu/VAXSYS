package com.vaxsys.constant;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ADMIN(1), PATIENT(2), NURSE(3), VENDOR(4);

    private int order;

    Role(int order) {
        this.order = order;
    }

    public com.vaxsys.entity.Role map() {
        return new com.vaxsys.entity.Role(this.order, this.toString());
    }

    public static List<Role> ADMIN_CREATION_ROLES = Arrays.asList(NURSE, VENDOR);
}
