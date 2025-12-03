package com.korit.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/method")
@RestController
public class MethodStudyController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.status(200).body(null);
    }

    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.status(200).body(null);
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.status(200).body(null);
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(200).body(null);
    }

}
