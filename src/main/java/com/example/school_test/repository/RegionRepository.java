package com.example.school_test.repository;

import com.example.school_test.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RegionRepository extends MongoRepository<Region, UUID> {
}
