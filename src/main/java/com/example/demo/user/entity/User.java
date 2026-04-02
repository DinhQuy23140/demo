package com.example.demo.user.entity;

import com.example.demo.department.entity.Faculty;
import com.example.demo.department.entity.FacultyRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Teacher teacher;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<FacultyRole> facultyRoleList;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<UserReseach> userReseachList;
}
