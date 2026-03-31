package com.example.demo.assignment.seed;

import com.example.demo.assignment.entity.ProjectTerm;
import com.example.demo.assignment.entity.Supervisor;
import com.example.demo.assignment.repository.ProjectTermRepository;
import com.example.demo.assignment.repository.SupervisorRepository;
import com.example.demo.user.entity.Teacher;
import com.example.demo.user.repository.TeacherRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SupervisorSeeder {
    private final SupervisorRepository supervisorRepository;
    private final TeacherRepository teacherRepository;
    private final ProjectTermRepository projectTermRepository;

    public List<Supervisor> seed() {
        Faker faker = new Faker();

        List<Teacher> teachers = teacherRepository.findAll();
        List<ProjectTerm> projectTerms = projectTermRepository.findAll();

        List<Supervisor> supervisors = new ArrayList<>();

        for (Teacher teacher : teachers) {

            ProjectTerm projectTerm = projectTerms.get(
                    faker.number().numberBetween(0, projectTerms.size())
            );

            Supervisor supervisor = Supervisor.builder()
                    .teacher(teacher)
                    .projectTerm(projectTerm)
                    .maxStudent(faker.number().numberBetween(3, 10))
                    .build();

            supervisors.add(supervisor);
        }

        return supervisorRepository.saveAll(supervisors);
    }
}
