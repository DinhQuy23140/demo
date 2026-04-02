package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.Assign;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> getAssignmentsByStudentId(Long studentId);

    List<Assignment> getAssignmentsByProjectTermIdAndStudentId(Long projectTerm_id, Long student_id);

    Assignment findFirstByStudent_IdOrderByIdDesc(Long studentId);
}
