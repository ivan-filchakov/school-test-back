package com.example.school_test.controller;

import com.example.school_test.model.Region;
import com.example.school_test.repository.RegionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable UUID id) {
        return regionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
