package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Teacher;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_student")
    private Integer maxStudent;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "project_term")
    private ProjectTerm projectTerm;
}
