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
    @JsonManagedReference
    @JoinColumn(name = "assinment_id")
    private Assignment assignment;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}
