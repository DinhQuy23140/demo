package com.example.demo.assignment.entity;

import com.example.demo.department.entity.Department;
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
@Table(name = "council")
public class Council {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "council_name")
    private String councilName;

    @Column(name = "council_code")
    private String councilCode;

    @Column(name = "description")
    private String description;

    @Column(name = "addres")
    private String address;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonBackReference
    @OneToMany(mappedBy = "council")
    private List<CouncilMember> councilMemberList;

    @JsonManagedReference
    @OneToMany(mappedBy = "council")
    private List<CouncilProject> councilProjectLists;
}
