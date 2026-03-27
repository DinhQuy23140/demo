package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Status")
    private String status;

    @Column(name = "counter_argument_status")
    private String counterArgumentStatus;

    @Column(name = "counter_argument_comment")
    private String counterArgumentComment;

    @ManyToOne
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

}
