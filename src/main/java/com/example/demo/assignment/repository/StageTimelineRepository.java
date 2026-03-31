package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.StageTimeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageTimelineRepository extends JpaRepository<StageTimeline, Long> {
}
