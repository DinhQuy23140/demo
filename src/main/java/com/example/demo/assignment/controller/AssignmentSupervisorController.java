package com.example.demo.assignment.controller;

import com.example.demo.assignment.dto.request.AssignmentSupervisorRequest;
import com.example.demo.assignment.entity.AssignmentSupervisor;
import com.example.demo.assignment.service.AssignmentSupervisorService;
import com.example.demo.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/assignment-supervisors")
public class AssignmentSupervisorController {

    private final AssignmentSupervisorService service;

    @GetMapping("/teacher/{teacherId}")
    ResponseEntity<ApiResponse<List<AssignmentSupervisor>>> getAssignmentSupervisorsByTeacherId(@PathVariable Long teacherId) {
        try {
            return ResponseEntity.ok(ApiResponse.success(service.getAssignmentSupervisorsByTeacherId(teacherId)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    @PostMapping
    ResponseEntity<ApiResponse<AssignmentSupervisor>> createAssignmentSupervisor(@RequestBody AssignmentSupervisorRequest request) {
        try {
            return ResponseEntity.ok(ApiResponse.success(service.createAssignmentSupervisor(request)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }
}
