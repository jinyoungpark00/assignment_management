package com.assignment.assignment_management.dto;

import com.assignment.assignment_management.domain.entity.Assignment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AssignmentRequestDTO {

    private Long id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    private String content;

    @Builder
    public AssignmentRequestDTO(String title, Date dueDate, String content) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.content = content;
    }

    public Assignment toEntity() {
        return Assignment.builder()
                .title(title)
                .dueDate(dueDate)
                .content(content)
                .build();
    }
}

