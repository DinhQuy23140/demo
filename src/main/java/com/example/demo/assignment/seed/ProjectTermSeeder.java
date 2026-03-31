package com.example.demo.assignment.seed;

import com.example.demo.assignment.entity.AcademyYear;
import com.example.demo.assignment.entity.ProjectTerm;
import com.example.demo.assignment.repository.AcademyYearRepository;
import com.example.demo.assignment.repository.ProjectTermRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectTermSeeder {
    private final AcademyYearRepository academyYearRepository;
    private final ProjectTermRepository projectTermRepository;

    public List<ProjectTerm> seed() {
        Faker faker = new Faker();
        List<ProjectTerm> projectTerms = new ArrayList<>();
        List<AcademyYear> academyYearList = academyYearRepository.findAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (AcademyYear academyYear : academyYearList) {

            String[] years = academyYear.getYearName().split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);

            String[] terms = {"Semester 1", "Semester 2", "Summer"};

            for (String term : terms) {

                LocalDate start;

                switch (term) {
                    case "Semester 1":
                        start = LocalDate.of(startYear, 9, 1);
                        break;

                    case "Semester 2":
                        start = LocalDate.of(endYear, 2, 1);
                        break;

                    default:
                        start = LocalDate.of(endYear, 6, 1);
                }

                LocalDate end = start.plusMonths(4);

                ProjectTerm projectTerm = ProjectTerm.builder()
                        .stage(term)
                        .description(faker.lorem().sentence())
                        .startDate(start.format(formatter))
                        .endDate(end.format(formatter))
                        .academyYear(academyYear)
                        .build();

                projectTerms.add(projectTerm);
            }
        }
        return projectTermRepository.saveAll(projectTerms);
    }
}
