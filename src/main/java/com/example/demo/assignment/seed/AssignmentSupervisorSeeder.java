package com.example.demo.assignment.seed;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.AssignmentSupervisor;
import com.example.demo.assignment.entity.Supervisor;
import com.example.demo.assignment.repository.AssignmentRepository;
import com.example.demo.assignment.repository.AssignmentSupervisorRepository;
import com.example.demo.assignment.repository.SupervisorRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class AssignmentSupervisorSeeder {
    private final AssignmentRepository assignmentRepository;
    private final SupervisorRepository supervisorRepository;
    private final AssignmentSupervisorRepository assignmentSupervisorRepository;

    public List<AssignmentSupervisor> seed() {
        Faker faker = new Faker();
        Random random = new Random();
        String[] roles = {"main", "coo"};
        String[] status = {"approved", "pending", "rejected"};
        List<Assignment> assignments = assignmentRepository.findAll();
        List<Supervisor> supervisors = supervisorRepository.findAll();

        List<AssignmentSupervisor> assignmentSupervisors = new ArrayList<>();

        // defensive checks: nếu không có data thì return rỗng
        if (assignments.isEmpty() || supervisors.isEmpty()) {
            return assignmentSupervisors;
        }

        // Tạo tối đa 100 bản ghi, nhưng không vượt quá tổ hợp assignments*supervisors (tùy bạn)
        int maxToCreate = 100;
        // tránh số vòng quá lớn nếu bạn chỉ có ít phần tử; có thể điều chỉnh theo nhu cầu
        int createCount = Math.min(maxToCreate, assignments.size() * supervisors.size());

        for (int index = 0; index < createCount; index++) {
            Assignment assignment = assignments.get(random.nextInt(assignments.size()));
            Supervisor supervisor = supervisors.get(random.nextInt(supervisors.size()));
            AssignmentSupervisor assignmentSupervisor = AssignmentSupervisor.builder()
                    .assignment(assignment)
                    .supervisor(supervisor)
                    .role(roles[random.nextInt(roles.length)])
                    .status(status[random.nextInt(status.length)])
                    .build();
            assignmentSupervisors.add(assignmentSupervisor);
        }
        return assignmentSupervisorRepository.saveAll(assignmentSupervisors);
    }
}