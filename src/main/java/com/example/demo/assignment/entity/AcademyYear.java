package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "academy_year")
public class AcademyYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year_name")
    private String yearName;

    @OneToMany(mappedBy = "academyYear")
    List<ProjectTerm> projectTermList;
}
