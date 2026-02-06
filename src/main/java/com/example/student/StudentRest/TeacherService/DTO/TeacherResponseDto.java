package com.example.student.StudentRest.TeacherService.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDto {

    private Long id;

    private String name;

    private String phoneNumber;

    private int age;

    private Long subjectId;
}
