package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "propose_topic")
public class ProposeTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "proposed_at")
    private String proposedAt;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}
