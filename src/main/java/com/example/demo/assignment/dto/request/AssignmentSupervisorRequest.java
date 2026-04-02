package com.example.demo.assignment.dto.request;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.Supervisor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssignmentSupervisorRequest {
    private Long Id;
    private String role;
    private String status;
    private String scoreReport;
    private String comment;
    private Long assignment_id;
    private Long supervisor_id;
}
