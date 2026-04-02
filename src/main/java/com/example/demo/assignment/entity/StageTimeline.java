package com.example.demo.assignment.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonManagedReference
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

}
