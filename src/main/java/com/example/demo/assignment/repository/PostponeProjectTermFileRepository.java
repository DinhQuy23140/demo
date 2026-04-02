package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.PostponeProjectTermFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostponeProjectTermFileRepository extends JpaRepository<PostponeProjectTermFile, Long> {

}
