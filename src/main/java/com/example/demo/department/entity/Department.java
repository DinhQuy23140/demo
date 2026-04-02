package com.example.demo.department.entity;

import com.example.demo.user.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonManagedReference
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    List<Teacher> teacherList;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    List<Marjor> marjorList;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    List<DepartmentRole> departmentRoleList;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    private List<Subject> subjectList;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    private List<Marjor> major;

}
