package com.example.demo.user.entity;

import com.example.demo.assignment.entity.Assignment;
import com.example.demo.assignment.entity.RegisterProjectTerm;
import com.example.demo.department.entity.Marjor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonManagedReference
    private User user;

    @OneToOne(mappedBy = "student")
    @JsonBackReference
    private Assignment assignment;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "marjor_id")
    private Marjor marjor;

    @JsonBackReference
    @OneToMany(mappedBy = "student")
    private List<RegisterProjectTerm> registerProjectTermList;
}
