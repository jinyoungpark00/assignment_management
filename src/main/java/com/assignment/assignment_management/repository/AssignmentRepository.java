package com.assignment.assignment_management.repository;


import com.assignment.assignment_management.domain.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Optional<Assignment> getAssignmentById(Long assignment_id);
}
