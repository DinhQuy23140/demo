package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Teacher;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_student")
    private Integer maxStudent;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "project_term")
    private ProjectTerm projectTerm;

    @OneToMany(mappedBy = "supervisor")
    private List<AssignmentSupervisor> assignmentSupervisorList;

    @OneToMany(mappedBy = "supervisor")
    private List<CouncilMember> councilMemberList;

//    @OneToMany(mappedBy = "supervisor")
//    private List<CouncilProject> councilProjectList;

    @OneToMany(mappedBy = "supervisor")
    private List<CommentLog> commentLogList;

    @OneToMany(mappedBy = "supervisor")
    private List<ProposeTopic> proposeTopicList;
}
