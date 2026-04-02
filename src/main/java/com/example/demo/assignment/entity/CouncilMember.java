package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @JoinColumn(name = "council_id")
    private Council council;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @JsonBackReference
    @OneToMany(mappedBy = "councilMember")
    List<CouncilProject> councilProjectList;

    @JsonBackReference
    @OneToMany(mappedBy = "councilMember")
    List<CouncilProjectDefences> councilProjectDefencesList;
}
