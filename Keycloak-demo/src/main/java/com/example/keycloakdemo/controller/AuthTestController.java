package com.example.keycloakdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequiredArgsConstructor
@RequestMapping("/testauth")
public class AuthTestController {

    @RolesAllowed("admin")
    @GetMapping("/method1")
    public String adminAuth() {
        return "Admin";
    }

    @RolesAllowed("user")
    @GetMapping("/method2")
    public String userAuth() {
        return "User";
    }

}
