package com.example.demo.user.seed;

import com.example.demo.department.entity.Marjor;
import com.example.demo.department.repository.MajorRepository;
import com.example.demo.user.entity.Student;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.StudentRepository;
import com.example.demo.user.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
@RequiredArgsConstructor
public class StudentSeeder {
    private final MajorRepository majorRepository;
    private final UserRepository userRepository;
    private final JsonMapper.Builder builder;
    private final StudentRepository studentRepository;

    public List<Student> seed() {
        List<Marjor> marjorList = majorRepository.findAll();
        List<User> users = userRepository.findAll();
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        Collections.shuffle(users);
        // shuffle majors too
        Collections.shuffle(marjorList);

        // limit number of students to number of majors to maintain 1-1
        int max = Math.min(users.size(), marjorList.size());
        for (int i = 0; i < max; i++) {
            User user = users.get(i);
            Marjor marjor = marjorList.get(i);
            Student student = Student.builder()
                    .studentCode("STU" + faker.number().digits(3))
                    .classCode("CLS" + faker.number().digits(3))
                    .graduationProject(false)
                    .user(user)
                    .marjor(marjor)
                    .build();
            students.add(student);
        }
        return studentRepository.saveAll(students);
    }

}
