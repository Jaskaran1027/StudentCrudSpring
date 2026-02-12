package com.example.student.StudentRest.TeacherService.DTO;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import com.example.student.StudentRest.SubjectService.Entity.SubjectEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherRequestDto {

    @NotNull(message = "Teacher Name is required")
    private String name;

    @NotNull(message = "Phone is Required")
    private String phoneNumber;

    private int age;

    private Long subjectId;
}
