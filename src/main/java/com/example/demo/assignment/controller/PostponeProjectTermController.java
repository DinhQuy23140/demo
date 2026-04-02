package com.example.demo.assignment.controller;

import com.example.demo.assignment.dto.request.PostponeProjectTermRequest;
import com.example.demo.assignment.service.PostponeProjectTermService;
import com.example.demo.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postpone-project-term")
@RequiredArgsConstructor
public class PostponeProjectTermController {
    private final PostponeProjectTermService postponeProjectTermService;

    ResponseEntity<ApiResponse<?>> createPostpone(PostponeProjectTermRequest request) {
        try {
            return ResponseEntity.ok(ApiResponse.success(postponeProjectTermService.create(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.error("An unexpected error occurred: " + e.getMessage()));
        }
    }

}
