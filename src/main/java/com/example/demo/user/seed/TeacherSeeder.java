package com.example.demo.user.seed;

import com.example.demo.department.entity.Department;
import com.example.demo.department.repository.DepartmentRepository;
import com.example.demo.user.entity.Teacher;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.TeacherRepository;
import com.example.demo.user.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TeacherSeeder {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final TeacherRepository teacherRepository;

    public List<Teacher> seed() {
        Faker faker = new Faker();
        List<Department> departments = departmentRepository.findAll();
        List<User> users = userRepository.findAll();
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Department department = departments.get(faker.number().numberBetween(0, departments.size()));
            User user = users.get(faker.number().numberBetween(0, users.size()));
            Teacher teacher = Teacher.builder()
                    .teacherCode("GV" + faker.number().digits(4))
                    .degree(faker.options().option(
                            "Bachelor", "Master", "PhD", "Associate Professor", "Professor"
                    ))
                    .position(faker.options().option(
                            "Lecturer", "Senior Lecturer", "Head of Department"
                    ))
                    .user(users.get(i))
                    .department(department)
                    .build();
            teachers.add(teacher);
        }
        return teacherRepository.saveAll(teachers);
    }
}
