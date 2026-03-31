package com.example.demo.user.repository;

import com.example.demo.user.entity.Research;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchRepository extends JpaRepository<Research, Long> {
}
