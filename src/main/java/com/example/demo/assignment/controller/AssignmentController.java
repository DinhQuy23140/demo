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

    @GetMapping("/projectTerm/{projectTermId}/student/{studentId}")
    ResponseEntity<ApiResponse<List<Assignment>>> getAssignmentsByProjectTermIdAndStudentId(@PathVariable Long projectTermId, @PathVariable Long studentId) {
        return ResponseEntity.ok(ApiResponse.success(assignmentService.getAssignmentsByProject_Term_IdAndStudent_Id(projectTermId, studentId)));
    }

    @GetMapping("/student/{studentId}/desc")
    ResponseEntity<ApiResponse<?>> findFirstByStudent_IdOrderByIdDesc(@PathVariable Long studentId) {
        return ResponseEntity.ok(ApiResponse.success(assignmentService.findFirstByStudent_IdOrderByIdDesc(studentId)));
    }
}
