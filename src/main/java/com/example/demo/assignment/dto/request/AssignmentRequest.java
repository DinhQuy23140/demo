package com.example.demo.assignment.dto.request;

import com.example.demo.assignment.entity.Project;
import com.example.demo.assignment.entity.ProjectTerm;
import com.example.demo.assignment.entity.Supervisor;
import com.example.demo.user.entity.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentRequest {
    private Long id;
    private String status;
    private String counterArgumentStatus;
    private String counterArgumentComment;
    private Long student_id;
    private Long project_id;
    private Long project_term_id;
    private Long counter_argument_id;
}
