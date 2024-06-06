package com.assignment.assignment_management.dto;

import com.assignment.assignment_management.domain.entity.Submission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubmissionRequestDTO {

    private Long id;

    private Double grade;
}
