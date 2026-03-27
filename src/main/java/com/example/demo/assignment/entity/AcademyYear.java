package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AcademyYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year_name")
    private String yearName;
}
