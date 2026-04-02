package com.example.demo.assignment.service;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Transactional
    public List<Assignment> getAssignmentByStudentId(Long studentId) {
        return assignmentRepository.getAssignmentsByStudentId(studentId);
    }
}
