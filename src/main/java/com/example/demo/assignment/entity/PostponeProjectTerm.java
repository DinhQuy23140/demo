package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post_pone_project_term")
public class PostponeProjectTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @OneToMany(mappedBy = "postponeProjectTerm")
    private List<PostponeProjectTermFile> postponeProjectTermFileList;
}
