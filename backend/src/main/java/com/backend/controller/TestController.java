package com.backend.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/auth/test")
    public String publicEndpoint() {
        return "Public endpoint";
    }

    @GetMapping("/users/test")
    public String privateEndpoint() {
        return "Private endpoint";
    }

    @GetMapping("/auth/hash")
    public String hashPassword() {

        return new BCryptPasswordEncoder().encode("123456");
    }
}