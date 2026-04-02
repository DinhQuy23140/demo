package com.example.demo.assignment.controller;

import com.example.demo.assignment.dto.request.PostponeProjectTermFileRequest;
import com.example.demo.assignment.dto.request.PostponeProjectTermRequest;
import com.example.demo.assignment.service.PostponeProjectTermFileService;
import com.example.demo.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostponeProjectTermFileController {
    private final PostponeProjectTermFileService service;

    ResponseEntity<ApiResponse<?>> create(PostponeProjectTermFileRequest request) {
        try {
            return ResponseEntity.ok(ApiResponse.success(service.create(request)));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error(e.getMessage()));
        }
    }
}
