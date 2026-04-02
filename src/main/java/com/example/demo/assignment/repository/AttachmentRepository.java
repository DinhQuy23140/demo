package com.example.demo.assignment.repository;

import com.example.demo.assignment.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> getAttachmentByProgressLogId(Long progressLogId);
}
