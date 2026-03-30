package com.example.demo.assignment.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stage_time_line", uniqueConstraints = @UniqueConstraint(
        columnNames = {"project_term_id", "number_of_round"}
))
public class StageTimeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_round")
    private Integer numberOfRound;

    @ManyToOne
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

}
