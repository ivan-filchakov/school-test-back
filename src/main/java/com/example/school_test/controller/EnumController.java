package com.example.school_test.controller;

import com.example.school_test.model.SchoolType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EnumController {

    @GetMapping("/api/school-types")
    public List<SchoolType> getSchoolTypes() {
        return Arrays.asList(SchoolType.values());
    }
}
