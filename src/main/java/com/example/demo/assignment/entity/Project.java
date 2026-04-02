package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToOne(mappedBy = "project")
    private Assignment assignment;

    @JsonBackReference
    @OneToMany(mappedBy = "project")
    private List<ProgressLog> progressLogList;

    @JsonBackReference
    @OneToMany(mappedBy = "project")
    private List<ReportFile> reportFileList;

}
