package com.example.school_test.loader;

import com.example.school_test.model.Region;
import com.example.school_test.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegionDataLoader implements CommandLineRunner {

    private final RegionRepository regionRepository;

    public RegionDataLoader(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (regionRepository.count() == 0) {
            List<Region> regions = List.of(
                new Region("Вінницька область"),
                new Region("Волинська область"),
                new Region("Дніпропетровська область"),
                new Region("Донецька область"),
                new Region("Київська область"),
                new Region("Львівська область"),
                new Region("Одеська область"),
                new Region("Харківська область")
            );
            regionRepository.saveAll(regions);
        }
    }
}
