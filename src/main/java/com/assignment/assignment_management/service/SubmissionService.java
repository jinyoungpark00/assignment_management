package com.assignment.assignment_management.service;

import com.assignment.assignment_management.domain.entity.Assignment;
import com.assignment.assignment_management.domain.entity.Submission;
import com.assignment.assignment_management.domain.entity.User;
import com.assignment.assignment_management.dto.SubmissionRequestDTO;
import com.assignment.assignment_management.repository.AssignmentRepository;
import com.assignment.assignment_management.repository.SubmissionRepository;
import com.assignment.assignment_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;

    public SubmissionService(SubmissionRepository submissionRepository, AssignmentRepository assignmentRepository, UserRepository userRepository) {
        this.submissionRepository = submissionRepository;
        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
    }

    public Submission getSubmission(Long submission_id) {
        return submissionRepository.getSubmissionById(submission_id)
                .orElseThrow(() -> new NullPointerException("해당 제출물이 존재하지 않습니다."));
    }

    @Transactional
    public void updateSubmission(Long submission_id, SubmissionRequestDTO submissionRequestDTO) {
        Submission submission = submissionRepository.getSubmissionById(submission_id)
                .orElseThrow(() -> new NullPointerException("해당 제출물이 존재하지 않습니다."));

        submission.evaluateGrade(submissionRequestDTO.getGrade());
    }
}
