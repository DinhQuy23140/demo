package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "report_file")
public class ReportFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "type_report")
    private String typeReport;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id ")
    private Project project;
}
