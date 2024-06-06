package com.assignment.assignment_management.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Date submitDate;

    private String AssignmentFile;

    @Column(columnDefinition = "Double DEFAULT 0.0")
    private Double grade;


    public Submission(Assignment assignment, User user, String assignmentFile) {
        this.assignment = assignment;
        this.user = user;
        this.submitDate = new Date();
        this.AssignmentFile = assignmentFile;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void evaluateGrade(Double grade) {
        this.grade = grade;
    }

}
