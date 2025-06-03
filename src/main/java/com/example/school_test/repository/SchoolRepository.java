package com.example.school_test.repository;

import com.example.school_test.model.School;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SchoolRepository extends MongoRepository<School, UUID> {
    boolean existsByEdrpou(String edrpou);
}

