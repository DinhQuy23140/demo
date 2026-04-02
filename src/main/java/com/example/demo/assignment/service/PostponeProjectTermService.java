package com.example.demo.assignment.service;

import com.example.demo.assignment.dto.request.PostponeProjectTermRequest;
import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.PostponeProjectTerm;
import com.example.demo.assignment.entity.ProjectTerm;
import com.example.demo.assignment.repository.PostponeProjectTermRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostponeProjectTermService {
    private final PostponeProjectTermRepository postponeProjectTermRepository;

    @PersistenceContext
    EntityManager entityManager;

    public PostponeProjectTerm create(PostponeProjectTermRequest request) {
        try {
            if (request.getAssignment_id() == null || request.getProject_term_id() == null) {
                throw new IllegalArgumentException("Assignment ID and Project Term ID must not be null.");
            }

            if (postponeProjectTermRepository.findByProject_Term_IdAndAssignmentId(request.getProject_term_id(), request.getAssignment_id())) {
                throw new RuntimeException("A postpone request already exists for this project term and assignment.");
            }

            Assignment assignment = entityManager.getReference(Assignment.class, request.getAssignment_id());
            ProjectTerm projectTerm = entityManager.getReference(ProjectTerm.class, request.getProject_term_id());
            PostponeProjectTerm postponeProjectTerm = PostponeProjectTerm.builder()
                    .note(request.getNote())
                    .status(request.getStatus())
                    .assignment(assignment)
                    .projectTerm(projectTerm)
                    .build();
            postponeProjectTermRepository.save(postponeProjectTerm);
            return postponeProjectTerm;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid input: " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException("Error creating postpone project term: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while creating postpone project term: " + e.getMessage());
        }
    }
}
