package com.example.demo.assignment.controller;

import com.example.demo.assignment.dto.request.AttachmentRequest;
import com.example.demo.assignment.entity.Attachment;
import com.example.demo.assignment.repository.AttachmentRepository;
import com.example.demo.assignment.service.AttachmentService;
import com.example.demo.common.ApiResponse;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attachments")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentService service;

    @GetMapping("/progress-log/progressLogId")
    ResponseEntity<ApiResponse<?>> getAttachmentByProgressLogId(Long progressLogId) {
        return ResponseEntity.ok(ApiResponse.success(service.getAttachmentByProgressLogId(progressLogId)));
    }

    @PostMapping
    ResponseEntity<ApiResponse<?>> createAttachment(AttachmentRequest request) {
        return ResponseEntity.ok(ApiResponse.success(service.createAttachment(request)));
    }
}
