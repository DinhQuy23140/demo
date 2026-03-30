package com.example.demo.assignment.entity;

import com.example.demo.department.entity.Department;
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
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "council")
    private List<CouncilMember> councilMemberList;

    @OneToMany(mappedBy = "council")
    private List<CouncilProject> councilProjectLists;
}
