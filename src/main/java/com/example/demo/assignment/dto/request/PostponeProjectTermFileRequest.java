package com.example.demo.assignment.dto.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostponeProjectTermFileRequest {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileType;
    private Long postpone_project_term_id;
}
