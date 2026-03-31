package com.example.demo.user.repository;

import com.example.demo.user.entity.VertificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VertificationTokenRepository extends JpaRepository<VertificationToken, Long> {
}
