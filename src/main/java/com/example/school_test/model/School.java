package com.example.school_test.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@Document(collection = "schools")
public class School {

    @Id
    private UUID id;

    private String name;
    @Indexed(unique = true)
    private String edrpou;
    @Field("type")
    private SchoolType type;
    private boolean isActive;
    private Region region;

    public School() {
        this.id = UUID.randomUUID();
    }

    public School(String name, String edrpou, SchoolType type, boolean isActive, Region region) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.edrpou = edrpou;
        this.type = type;
        this.isActive = isActive;
        this.region = region;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public SchoolType getType() {
        return type;
    }

    public void setType(SchoolType type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Region getRegion() {
        return region;
    }
    
    public void setRegion(Region region) {
        this.region = region;
    }
}
