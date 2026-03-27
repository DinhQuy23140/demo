package com.example.demo.assignment.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProgressLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "start_date_time")
    private String startDateTime;

    @Column(name = "end_date_time")
    private String endDateTime;

    @Column(name = "instructor_comment")
    private String instructorComment;

    @Column(name = "student_status")
    private String studentStatus;

    @Column(name = "instructor_status")
    private String instructorStatus;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
