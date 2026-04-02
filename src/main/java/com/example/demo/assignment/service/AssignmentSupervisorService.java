package com.example.demo.assignment.service;

import com.example.demo.assignment.dto.request.AssignmentSupervisorRequest;
import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.AssignmentSupervisor;
import com.example.demo.assignment.entity.Supervisor;
import com.example.demo.assignment.repository.AssignmentSupervisorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentSupervisorService {
    private final AssignmentSupervisorRepository assignmentSupervisorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public AssignmentSupervisor createAssignmentSupervisor(AssignmentSupervisorRequest request) {
        try {
            if (request.getAssignment_id() == null || request.getSupervisor_id() == null) {
                throw new IllegalArgumentException("Assignment ID and Supervisor ID cannot be null");
            }

            if (assignmentSupervisorRepository.findByAssignmentIdAndSupervisorId(request.getAssignment_id(), request.getSupervisor_id())) {
                throw new IllegalArgumentException("An AssignmentSupervisor with the given Assignment ID and Supervisor ID already exists");
            }
            Assignment assignment = request.getAssignment_id() != null ? entityManager.find(Assignment.class, request.getAssignment_id()) : null;
            Supervisor supervisor = request.getSupervisor_id() != null ? entityManager.find(Supervisor.class, request.getSupervisor_id()) : null;

            AssignmentSupervisor assignmentSupervisor = AssignmentSupervisor.builder()
                    .role(request.getRole())
                    .status(request.getStatus())
                    .scoreReport(request.getScoreReport() != null ? request.getScoreReport() : "")
                    .comment(request.getComment() != null ? request.getComment() : "")
                    .assignment(assignment)
                    .supervisor(supervisor)
                    .build();
            return assignmentSupervisorRepository.save(assignmentSupervisor);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save AssignmentSupervisor: " + e.getMessage(), e);
        }
    }

    public List<AssignmentSupervisor> getAssignmentSupervisorsByTeacherId(Long teacherId) {
        return assignmentSupervisorRepository.findByTeacherId(teacherId);
    }
}
