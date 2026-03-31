package com.example.demo.department.seed;

import com.example.demo.department.entity.Department;
import com.example.demo.department.entity.Marjor;
import com.example.demo.department.repository.DepartmentRepository;
import com.example.demo.department.repository.MajorRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MajorSeeder {
    private final MajorRepository majorRepository;
    private final DepartmentRepository departmentRepository;

    public List<Marjor> seed() {
        List<Marjor> marjorList = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        Faker faker = new Faker();

        for (int index = 0; index < 10; index++) {
            Department department = departments.get(faker.number().numberBetween(0, departments.size()));
            Marjor marjor = Marjor.builder()
                    .marjorCode("MAR" + faker.number().digits(3))
                    .marjorName(faker.educator().course()+ "Major")
                    .description(faker.lorem().sentence())
                    .department(department)
                    .build();
            marjorList.add(marjor);
        }
        return majorRepository.saveAll(marjorList);
    }
}
