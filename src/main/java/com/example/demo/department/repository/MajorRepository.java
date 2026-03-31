package com.example.demo.department.repository;

import com.example.demo.department.entity.Marjor;
import org.hibernate.mapping.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Marjor, Long> {
}
