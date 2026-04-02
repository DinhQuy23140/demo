package com.example.demo.assignment.service;

import com.example.demo.assignment.dto.request.PostponeProjectTermFileRequest;
import com.example.demo.assignment.entity.PostponeProjectTerm;
import com.example.demo.assignment.entity.PostponeProjectTermFile;
import com.example.demo.assignment.repository.PostponeProjectTermFileRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostponeProjectTermFileService {
    private final PostponeProjectTermFileRepository postponeProjectTermFileRepository;

    @PersistenceContext
    EntityManager entityManager;

    public PostponeProjectTermFile create(PostponeProjectTermFileRequest request) {
        PostponeProjectTerm postponeProjectTerm = entityManager.getReference(PostponeProjectTerm.class, request.getPostpone_project_term_id());
        PostponeProjectTermFile file = PostponeProjectTermFile.builder()
                .fileName(request.getFileName())
                .filePath(request.getFilePath())
                .fileType(request.getFileType())
                .postponeProjectTerm(postponeProjectTerm)
                .build();
        return postponeProjectTermFileRepository.save(file);
    }
}
