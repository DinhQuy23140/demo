package com.example.demo.assignment.entity;

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
    @JoinColumn(name = "council_id")
    private Council council;

    @OneToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "council_member_id")
    private CouncilMember councilMember;

    @OneToMany(mappedBy = "councilProject")
    private List<CouncilProjectDefences> councilProjectDefencesList;
}
