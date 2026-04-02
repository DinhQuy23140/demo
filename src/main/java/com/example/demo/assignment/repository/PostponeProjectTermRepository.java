package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.PostponeProjectTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostponeProjectTermRepository extends JpaRepository<PostponeProjectTerm, Long> {
    Boolean findByProject_Term_IdAndAssignmentId(Long projectTermId, Long assignmentId);
}
