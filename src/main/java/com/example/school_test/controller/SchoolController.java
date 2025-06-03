package com.example.school_test.controller;

import com.example.school_test.model.School;
import com.example.school_test.service.SchoolService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getAll() {
        return schoolService.getAllSchools();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody School data) {
        School created = schoolService.createSchool(data);
    
        return ResponseEntity.ok(created);
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        boolean success = schoolService.deactivateSchool(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
