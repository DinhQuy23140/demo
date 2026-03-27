package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProjectTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stage")
    private String stage;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "academy_year_id")
    private AcademyYear academyYear;
}
