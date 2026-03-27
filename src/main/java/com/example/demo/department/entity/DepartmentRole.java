package com.example.demo.department.entity;

import com.example.demo.user.entity.Teacher;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "department_role")
public class DepartmentRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
