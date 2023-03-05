package com.datmt.keycloak.springbootauth.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@PreAuthorize("isAuthenticated()")
public class HelloController {

    @GetMapping
    @PreAuthorize("hasRole('MENTOR-DEV')")
    public ResponseEntity<Object> getUsers(@RequestHeader HttpHeaders httpHeaders) {
        System.out.println("User: " + SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("User: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return ResponseEntity.ok().body("Hi user!");
    }
}