package com.example.demo.user.entity;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.RegisterProjectTerm;
import com.example.demo.department.entity.Marjor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_code")
    private String studentCode;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "graduation_project")
    private Boolean graduationProject;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "student")
    private Assignment assignment;

    @OneToOne
    @JoinColumn(name = "marjor_id")
    private Marjor marjor;

    @OneToMany(mappedBy = "student")
    private List<RegisterProjectTerm> registerProjectTermList;
}
