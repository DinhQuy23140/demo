package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
