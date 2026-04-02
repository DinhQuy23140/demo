package com.example.demo.assignment.controller;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.service.AssignmentService;
import com.example.demo.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping("/student/{studentId}")
    ResponseEntity<ApiResponse<List<Assignment>>> getAssignmentByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(ApiResponse.success(assignmentService.getAssignmentByStudentId(studentId)));
    }
}
