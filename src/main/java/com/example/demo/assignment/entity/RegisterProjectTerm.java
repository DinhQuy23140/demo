package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "register_project_term")
public class RegisterProjectTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;
}
