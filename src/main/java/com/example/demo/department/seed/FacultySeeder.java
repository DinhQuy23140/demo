package com.example.demo.department.seed;

import com.example.demo.department.entity.Faculty;
import com.example.demo.department.repository.FacultyRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FacultySeeder {
    private final FacultyRepository facultyRepository;

    public List<Faculty> seed() {
        Faker faker = new Faker();
        List<Faculty> faculties = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Faculty faculty = Faculty.builder()
                    .facultyCode("FAC" + faker.number().digits(3))
                    .facultyName("Faculty of " + faker.educator().course())
                    .facultyShortName(faker.university().name().substring(0,3).toUpperCase())
                    .description(faker.lorem().sentence())
                    .phoneNumber(faker.phoneNumber().cellPhone())
                    .email(faker.internet().emailAddress())
                    .address(faker.address().fullAddress())
                    .build();
            faculties.add(faculty);
        }
        return facultyRepository.saveAll(faculties);
    }
}
