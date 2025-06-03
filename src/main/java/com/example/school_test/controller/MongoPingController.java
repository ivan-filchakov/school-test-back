package com.example.school_test.controller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoPingController {

    private final MongoTemplate mongoTemplate;

    public MongoPingController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/api/ping-mongo")
    public String pingMongo() {
        String dbName = mongoTemplate.getDb().getName();
        return "Connected to DB: " + dbName;
    }
}
