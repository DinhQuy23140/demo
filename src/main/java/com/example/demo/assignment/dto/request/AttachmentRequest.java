package com.example.demo.assignment.dto.request;

import com.example.demo.assignment.entity.ProgressLog;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttachmentRequest {
    private Long id;
    private String fileName;
    private String fileType;
    private String fileUrl;
    private String uploadTime;
    private Long progressLogId;
}
