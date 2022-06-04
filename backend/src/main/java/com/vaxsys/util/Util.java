package com.vaxsys.util;

import com.vaxsys.entity.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {

    public static void passwordGenerator(String plainTextPassword) {
        System.out.println(new BCryptPasswordEncoder().encode(plainTextPassword));
    }

    public static CurrentUser getCurrentUser(){
        return (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
