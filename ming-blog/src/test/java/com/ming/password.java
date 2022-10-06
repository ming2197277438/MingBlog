package com.ming;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class password {
    public static void main(String[] args) {
        String pass = "123456";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String passHash = encoder.encode(pass);
        System.out.println(passHash);

        final boolean matches = encoder.matches(pass, passHash);
        System.out.println(matches);
    }
}
