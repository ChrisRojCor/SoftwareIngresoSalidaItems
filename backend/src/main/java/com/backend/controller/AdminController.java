package com.backend.controller;

import com.backend.security.config.Roles;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('" + Roles.ADMIN + "')")
public class AdminController {

    @GetMapping("/test")
    public String adminTest() {

        return "Admin endpoint";
    }
}