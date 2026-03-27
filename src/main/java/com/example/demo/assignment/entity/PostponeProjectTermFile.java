package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "postpone_project_term_file")
public class PostponeProjectTermFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "postpone_project_term_id")
    private PostponeProjectTerm postponeProjectTerm;
}
