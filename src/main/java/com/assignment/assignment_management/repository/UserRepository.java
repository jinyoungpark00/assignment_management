package com.assignment.assignment_management.repository;

import com.assignment.assignment_management.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
