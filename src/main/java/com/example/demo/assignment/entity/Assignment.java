package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "assignment")
@NoArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "counter_argument_status")
    private String counterArgumentStatus;

    @Column(name = "counter_argument_comment")
    private String counterArgumentComment;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

    @ManyToOne
    @JoinColumn(name = "counter_argument_id")
    private Supervisor supervisor;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSupervisor> assignmentSupervisors;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSupervisor> assignmentSupervisorList;

    @OneToOne(mappedBy = "assignment")
    private CouncilProject councilProject;

    @OneToMany(mappedBy = "assignment")
    private List<PostponeProjectTerm> postponeProjectTermList;
}
