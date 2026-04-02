package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "council_project")
public class CouncilProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room")
    private String room;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "review_score")
    private String review_score;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "council_id")
    private Council council;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "council_member_id")
    private CouncilMember councilMember;

    @JsonBackReference
    @OneToMany(mappedBy = "councilProject")
    private List<CouncilProjectDefences> councilProjectDefencesList;
}
