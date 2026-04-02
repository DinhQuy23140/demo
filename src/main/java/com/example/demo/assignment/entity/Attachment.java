package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "upload_time")
    private String uploadTime;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "progress_log_id")
    private ProgressLog progressLog;
}
