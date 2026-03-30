package com.example.demo.department.entity;

import com.example.demo.user.entity.Teacher;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "department")
    List<Teacher> teacherList;

    @OneToMany(mappedBy = "department")
    List<Marjor> marjorList;

    @OneToMany(mappedBy = "department")
    List<DepartmentRole> departmentRoleList;

    @OneToMany(mappedBy = "department")
    private List<Subject> subjectList;

    @OneToMany(mappedBy = "department")
    private List<Marjor> major;

}
