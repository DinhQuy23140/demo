package com.example.demo.department.entity;

import com.example.demo.user.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lecturer_subject")
public class LecturerSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semester")
    private String semester;

    @Column(name = "year")
    private String year;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
