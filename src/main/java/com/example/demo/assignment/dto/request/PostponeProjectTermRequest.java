package com.example.demo.assignment.dto.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostponeProjectTermRequest {
    private Long id;
    private String note;
    private String status;
    private Long project_term_id;
    private Long assignment_id;
}
