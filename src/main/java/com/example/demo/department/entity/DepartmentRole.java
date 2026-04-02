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
@Table(name = "department_role")
public class DepartmentRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
