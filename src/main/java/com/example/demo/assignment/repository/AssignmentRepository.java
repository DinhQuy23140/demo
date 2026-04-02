package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.Assign;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> getAssignmentsByStudent_Id(Long studentId);

    List<Assignment> getAssignmentsByProject_Term_IdAndStuden_tId(Long projectTerm_id, Long student_id);

    Optional<Assignment> findFirstByStudent_IdOrderByIdDesc(Long studentId);
}
