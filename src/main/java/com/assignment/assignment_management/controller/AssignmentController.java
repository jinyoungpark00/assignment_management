package com.assignment.assignment_management.controller;

import com.assignment.assignment_management.domain.entity.Assignment;
import com.assignment.assignment_management.dto.AssignmentRequestDTO;
import com.assignment.assignment_management.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/assignment")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping("/")
    public String getAssignmentList(Model model) {
        List<Assignment> assignmentList = assignmentService.getAssignmentList();
        model.addAttribute("assignmentList", assignmentList);

        return "getAssignmentList";
    }

    @GetMapping("/{id}")
    public String getAssignment(@PathVariable("id") Long assignment_id, Model model) {
        Assignment assignment = assignmentService.getAssignment(assignment_id);

        model.addAttribute("assignment", assignment);

        return "getAssignment";
    }

    @GetMapping("/new")
    public String newAssignmentForm(Model model) {
        model.addAttribute("assignmentRequestDTO", new AssignmentRequestDTO());
        return "newAssignment";
    }

    @PostMapping("/")
    public String postAssignment(@ModelAttribute AssignmentRequestDTO assignmentRequestDTO) {
        Long assignmentId = assignmentService.saveAssignment(assignmentRequestDTO);
        return "redirect:/assignment/" + assignmentId;
    }


    @GetMapping("/{id}/edit-assignment")
    public String editAssignmentForm(@PathVariable("id") Long assignment_id, Model model) {
        Assignment assignment = assignmentService.getAssignment(assignment_id);
        AssignmentRequestDTO assignmentRequestDTO = new AssignmentRequestDTO();
        BeanUtils.copyProperties(assignment, assignmentRequestDTO);
        model.addAttribute("assignmentRequestDTO", assignmentRequestDTO);
        return "editAssignment";
    }

    @PostMapping("/{id}/edit-assignment")
    public String updateAssignment(@PathVariable("id") Long assignment_id, @ModelAttribute AssignmentRequestDTO assignmentRequestDTO) {
        assignmentService.updateAssignment(assignment_id, assignmentRequestDTO);
        return "redirect:/assignment/{id}";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssignment(@PathVariable("id") Long assignment_id) {
        assignmentService.deleteAssignment(assignment_id);
        return "redirect:/assignment/";
    }
}
