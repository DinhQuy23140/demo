package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_term")
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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "academy_year_id")
    private AcademyYear academyYear;

    @JsonBackReference
    @OneToMany(mappedBy = "projectTerm")
    private List<Assignment> assignmentList;

    @JsonBackReference
    @OneToMany(mappedBy = "projectTerm")
    private List<Supervisor> supervisorList;

    @JsonBackReference
    @OneToMany(mappedBy = "projectTerm")
    private List<StageTimeline> stageTimelineList;

    @JsonBackReference
    @OneToMany(mappedBy = "projectTerm")
    private List<Council> councilList;

    @JsonBackReference
    @OneToMany(mappedBy = "projectTerm")
    private List<RegisterProjectTerm> registerProjectTermList;

    @JsonBackReference
    @OneToMany(mappedBy = "projectTerm")
    private List<PostponeProjectTerm> postponeProjectTermList;
}
