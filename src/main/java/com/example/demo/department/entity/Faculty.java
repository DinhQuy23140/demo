package com.example.demo.department.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "faculty_code")
    private String facultyCode;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "faculty_short_name")
    private String facultyShortName;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "faculty")
    @JsonBackReference
    private List<Department> departmentList;

    @OneToMany(mappedBy = "faculty")
    @JsonBackReference
    private List<FacultyRole> facultyRoleList;
}
