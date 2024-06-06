package com.assignment.assignment_management.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String email;
    private String name;
    private String phoneNum;
    private String userLocInfo;

    // Student : 1, Professor : 0
    private Boolean isStudent;
}
