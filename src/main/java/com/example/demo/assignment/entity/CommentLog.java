package com.example.demo.assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment_log")
public class CommentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "progress_log_id")
    private ProgressLog progressLog;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}
