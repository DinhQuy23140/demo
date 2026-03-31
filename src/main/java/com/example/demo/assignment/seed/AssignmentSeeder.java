package com.example.demo.assignment.seed;


import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.ProjectTerm;
import com.example.demo.assignment.repository.AssignmentRepository;
import com.example.demo.assignment.repository.ProjectTermRepository;
import com.example.demo.user.entity.Student;
import com.example.demo.user.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class AssignmentSeeder {
    private final AssignmentRepository assignmentRepository;
    private final ProjectTermRepository projectTermRepository;
    private final StudentRepository studentRepository;
    public List<Assignment> seed() {
        List<ProjectTerm> projectTerms = projectTermRepository.findAll();
        List<Student> students = new ArrayList<>(studentRepository.findAll());
        List<Assignment> assignments = new ArrayList<>();
        String[] statuses = {"pending", "cancelled", "actived", "stopped"};

        if (students.isEmpty()) {
            return assignments; // không có student -> không tạo assignment
        }

        Random random = new Random();

        // Shuffle students để chọn mỗi student tối đa 1 lần (không trùng)
        Collections.shuffle(students);

        // Số assignment muốn tạo: tối đa bằng số students để tránh unique-violation
        int createCount = Math.min(100, students.size());

        for (int i = 0; i < createCount; i++) {
            Student student = students.get(i);

            ProjectTerm projectTerm = projectTerms.isEmpty()
                    ? null
                    : projectTerms.get(random.nextInt(projectTerms.size()));

            Assignment assignment = Assignment.builder()
                    .student(student)
                    .projectTerm(projectTerm)
                    .status(statuses[random.nextInt(statuses.length)])
                    .build();

            assignments.add(assignment);
        }

        return assignmentRepository.saveAll(assignments);
    }

}
