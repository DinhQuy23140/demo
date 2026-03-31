package com.example.demo.department.seed;

import com.example.demo.department.entity.Department;
import com.example.demo.department.entity.Faculty;
import com.example.demo.department.repository.DepartmentRepository;
import com.example.demo.department.repository.FacultyRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentSeeder {
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;

    public List<Department> seed() {
        List<Department> departments = new ArrayList<>();
        List<Faculty> faculties = facultyRepository.findAll();
        Faker faker = new Faker();
        for (int index = 0; index < 10; index++) {
            Faculty faculty = faculties.get((faker.number().numberBetween(0, faculties.size())));
            String departmentName = faker.educator().course() + "Department";
            Department department = Department.builder()
                    .faculty(faculty)
                    .departmentCode("DEP" + faker.number().digits(3))
                    .departmentName(departmentName)
                    .description(faker.lorem().sentence())
                    .build();
            departments.add(department);
        }
        return departmentRepository.saveAll(departments);
    }
}
