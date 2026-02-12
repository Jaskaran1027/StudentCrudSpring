package com.example.student.StudentRest.TeacherService.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponseDto {

    private Long id;

    private String name;

    private String phoneNumber;

    private int age;

    private Long subjectId;
}
