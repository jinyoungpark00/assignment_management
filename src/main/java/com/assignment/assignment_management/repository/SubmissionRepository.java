package com.assignment.assignment_management.repository;

import com.assignment.assignment_management.domain.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    Optional<Submission> getSubmissionById(Long submission_id);
}
