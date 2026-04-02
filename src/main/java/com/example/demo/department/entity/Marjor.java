package com.example.demo.department.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marjor")
public class Marjor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marjor_code")
    private String marjorCode;

    @Column(name = "marjor_name")
    private String marjorName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "department_id")
    private Department department;
}
