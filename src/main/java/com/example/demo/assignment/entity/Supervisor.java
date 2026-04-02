package com.example.demo.assignment.entity;

import com.example.demo.user.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_student")
    private Integer maxStudent;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "project_term_id")
    private ProjectTerm projectTerm;

    @OneToMany(mappedBy = "supervisor")
    @JsonBackReference
    private List<AssignmentSupervisor> assignmentSupervisorList;

    @OneToMany(mappedBy = "supervisor")
    @JsonBackReference
    private List<CouncilMember> councilMemberList;

//    @OneToMany(mappedBy = "supervisor")
//    private List<CouncilProject> councilProjectList;

    @JsonBackReference
    @OneToMany(mappedBy = "supervisor")
    private List<CommentLog> commentLogList;

    @JsonBackReference
    @OneToMany(mappedBy = "supervisor")
    private List<ProposeTopic> proposeTopicList;
}
