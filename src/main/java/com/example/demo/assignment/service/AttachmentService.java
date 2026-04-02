package com.example.demo.assignment.service;

import com.example.demo.assignment.dto.request.AttachmentRequest;
import com.example.demo.assignment.entity.Attachment;
import com.example.demo.assignment.entity.ProgressLog;
import com.example.demo.assignment.repository.AttachmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    private final AttachmentRepository repository;
    public List<Attachment> getAttachmentByProgressLogId(Long progressLogId) {
        return repository.getAttachmentByProgressLogId(progressLogId);
    }

    @PersistenceContext
    EntityManager entityManager;

    public Attachment createAttachment(AttachmentRequest request) {
        ProgressLog progressLog = entityManager.getReference(ProgressLog.class, request.getProgressLogId());
        Attachment attachment = Attachment.builder()
                .fileName(request.getFileName())
                .fileType(request.getFileType())
                .fileUrl(request.getFileUrl())
                .uploadTime(request.getUploadTime())
                .progressLog(progressLog)
                .build();
        return repository.save(attachment);
    }
}
