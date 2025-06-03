package com.example.school_test.service;

import com.example.school_test.model.School;
import com.example.school_test.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(UUID id) {
        return schoolRepository.findById(id);
    }

    public School createSchool(School school) {
        if (schoolRepository.existsByEdrpou(school.getEdrpou())) {
            throw new IllegalArgumentException("School with this EDRPOU already exists");
        }
        school.setActive(true);
        return schoolRepository.save(school);
    }

    public boolean deactivateSchool(UUID id) {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isPresent()) {
            School school = optionalSchool.get();
            school.setActive(false);
            schoolRepository.save(school);
            return true;
        } else {
            return false;
        }
    }
    
}
