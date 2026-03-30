package com.example.demo.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "council_member")
public class CouncilMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "council_id")
    private Council council;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @OneToMany(mappedBy = "councilMember")
    List<CouncilProject> councilProjectList;

    @OneToMany(mappedBy = "councilMember")
    List<CouncilProjectDefences> councilProjectDefencesList;
}
