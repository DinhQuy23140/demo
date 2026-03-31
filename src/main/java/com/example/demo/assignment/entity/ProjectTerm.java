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

    @ManyToOne
    @JoinColumn(name = "academy_year_id")
    private AcademyYear academyYear;

    @OneToMany(mappedBy = "projectTerm")
    private List<Assignment> assignmentList;

    @OneToMany(mappedBy = "projectTerm")
    private List<Supervisor> supervisorList;

    @OneToMany(mappedBy = "projectTerm")
    private List<StageTimeline> stageTimelineList;

    @OneToMany(mappedBy = "projectTerm")
    private List<Council> councilList;

    @OneToMany(mappedBy = "projectTerm")
    private List<RegisterProjectTerm> registerProjectTermList;

    @OneToMany(mappedBy = "projectTerm")
    private List<PostponeProjectTerm> postponeProjectTermList;
}
