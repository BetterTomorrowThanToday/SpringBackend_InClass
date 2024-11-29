package com.example.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class healthCheck {
    @GetMapping("/healthcheck")
    public ResponseEntity<String> getHealthCheck() {
        return ResponseEntity.ok("OK");
    }
}