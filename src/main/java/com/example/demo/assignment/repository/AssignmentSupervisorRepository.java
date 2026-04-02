package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.AssignmentSupervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentSupervisorRepository extends JpaRepository<AssignmentSupervisor, Long> {
    @Query("""
        SELECT a
        FROM AssignmentSupervisor a
        WHERE a.supervisor.teacher.id = :teacherId
        """)
    List<AssignmentSupervisor> findByTeacherId(Long teacherId);

    Boolean findByAssignmentIdAndSupervisorId(Long assignment_id, Long supervisor_id);


}
