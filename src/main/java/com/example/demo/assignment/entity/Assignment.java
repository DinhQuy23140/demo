package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "counter_argument_id")
    private Supervisor supervisor;

    @JsonBackReference
    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSupervisor> assignmentSupervisors;

    @JsonBackReference
    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSupervisor> assignmentSupervisorList;

    @JsonBackReference
    @OneToOne(mappedBy = "assignment")
    private CouncilProject councilProject;

    @JsonBackReference
    @OneToMany(mappedBy = "assignment")
    private List<PostponeProjectTerm> postponeProjectTermList;
}
