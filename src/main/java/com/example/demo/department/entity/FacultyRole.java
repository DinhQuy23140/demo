package com.example.demo.department.entity;

import com.example.demo.user.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "faculty_role")
public class FacultyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;
}
