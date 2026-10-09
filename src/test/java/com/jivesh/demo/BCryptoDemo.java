package com.jivesh.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptoDemo {
    public static void main(String[] args) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        String h1 = enc.encode("test12345");
        String h2 = enc.encode("test12345");
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h1.equals(h2));
        System.out.println(enc.matches("test12345", h1));
        System.out.println(enc.matches("wrong", h1));
        System.out.println(enc.matches("test12345", h2));
    }
}