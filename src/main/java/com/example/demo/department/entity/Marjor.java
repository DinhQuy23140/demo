package com.example.demo.department.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marjor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "marjor_code")
    private String marjorCode;

    @Column(name = "marjor_name")
    private String marjorName;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
