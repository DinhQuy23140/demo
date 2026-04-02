package com.example.demo.assignment.service;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignmentByStudentId(Long studentId) {
        return assignmentRepository.getAssignmentsByStudent_Id(studentId);
    }

    public List<Assignment> getAssignmentsByProject_Term_IdAndStudent_Id(Long projectTerm_id, Long student_id) {
        return assignmentRepository.getAssignmentsByProject_Term_IdAndStuden_tId(projectTerm_id, student_id);
    }

    public Optional<Assignment> findFirstByStudent_IdOrderByIdDesc(Long studentId) {
        return assignmentRepository.findFirstByStudent_IdOrderByIdDesc(studentId);
    }
}
