package com.example.demo.department.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "sobject_name")
    private String subjectName;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_credits")
    private String numberOdCredits;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "subject")
    private List<LecturerSubject> lecturerSubjectList;
}
