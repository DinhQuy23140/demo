package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "council_project_defences")
public class CouncilProjectDefences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score")
    private String score;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "council_project_id")
    private CouncilProject councilProject;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "council_member_id")
    private CouncilMember councilMember;
}
