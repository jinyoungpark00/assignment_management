package com.assignment.assignment_management.controller;

import com.assignment.assignment_management.domain.entity.Submission;
import com.assignment.assignment_management.dto.SubmissionRequestDTO;
import com.assignment.assignment_management.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/submission")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;


    @GetMapping("/{id}/evaluate-grade")
    public String editSubmissionForm(@PathVariable("id") Long submission_id, Model model) {
        Submission submission = submissionService.getSubmission(submission_id);
        SubmissionRequestDTO submissionRequestDTO = new SubmissionRequestDTO();
        BeanUtils.copyProperties(submission, submissionRequestDTO);
        model.addAttribute("submissionRequestDTO", submissionRequestDTO);
        return "editSubmission";
    }

    @PostMapping("/{id}/evaluate-grade")
    public String updateSubmission(@PathVariable("id") Long submission_id, @ModelAttribute SubmissionRequestDTO submissionRequestDTO) {
        submissionService.updateSubmission(submission_id, submissionRequestDTO);
        return "redirect:/assignment/";
    }

}
