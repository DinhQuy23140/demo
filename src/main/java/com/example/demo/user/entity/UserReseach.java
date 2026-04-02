package com.example.demo.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_research")
public class UserReseach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "research_id")
    private Research research;
}
