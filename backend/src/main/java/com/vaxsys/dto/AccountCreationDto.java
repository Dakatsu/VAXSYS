package com.vaxsys.dto;

import com.vaxsys.constant.Role;

public class AccountCreationDto {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final Role role;

    public AccountCreationDto(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
