package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "assignment_supervisor")
public class AssignmentSupervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "role")
    private String role;
    @Column(name = "status")
    private String status;

    @Column(name = "score_report")
    private String scoreReport;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "assinment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}
