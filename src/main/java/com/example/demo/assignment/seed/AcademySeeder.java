package com.example.demo.assignment.seed;

import com.example.demo.assignment.entity.AcademyYear;
import com.example.demo.assignment.repository.AcademyYearRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AcademySeeder {
    private final AcademyYearRepository academyYearRepository;
    public List<AcademyYear> seed() {
        if (academyYearRepository.count() > 0) return academyYearRepository.findAll();
        List<AcademyYear> academyYearList = new ArrayList<>();
        int startYear = 2005;
        int currentYear = Year.now().getValue();
        for (int year = startYear; year <= currentYear; year++) {
            AcademyYear academyYear = AcademyYear.builder()
                    .yearName(year + "-" + (year + 1))
                    .build();
            academyYearList.add(academyYear);
        }
        return academyYearRepository.saveAll(academyYearList);
    }
}
