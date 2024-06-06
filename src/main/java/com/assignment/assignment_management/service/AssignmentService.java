package com.assignment.assignment_management.service;


import com.assignment.assignment_management.domain.entity.Assignment;
import com.assignment.assignment_management.dto.AssignmentRequestDTO;
import com.assignment.assignment_management.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignmentList() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignment(Long assignment_id) {
        return assignmentRepository.getAssignmentById(assignment_id)
                .orElseThrow(() -> new NullPointerException("해당 과제가 존재하지 않습니다."));
    }

    @Transactional
    public Long saveAssignment(AssignmentRequestDTO assignmentRequestDTO) {
        Assignment assignment = assignmentRequestDTO.toEntity();
        assignmentRepository.save(assignment);
        return assignment.getId();
    }

    @Transactional
    public void updateAssignment(Long assignment_id, AssignmentRequestDTO assignmentRequestDTO) {
        Assignment assignment = assignmentRepository.getAssignmentById(assignment_id)
                .orElseThrow(() -> new NullPointerException("해당 과제가 존재하지 않습니다."));
        assignment.updateAssignment(assignmentRequestDTO.getTitle(), assignmentRequestDTO.getDueDate(), assignmentRequestDTO.getContent());
    }

    @Transactional
    public void deleteAssignment(Long assignment_id) {
        assignmentRepository.deleteById(assignment_id);
    }
}
