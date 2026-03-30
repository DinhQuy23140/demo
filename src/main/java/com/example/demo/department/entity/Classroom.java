package com.example.demo.department.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "class_name")
    private String className;

    @Column(name = "number_student")
    private Integer numberStudent;

    @Column(name = "addmession_year")
    private String addmissionYear;

    @Column(name = "cohort")
    private String cohort;

    @Column(name = "description")
    private String description;
}
