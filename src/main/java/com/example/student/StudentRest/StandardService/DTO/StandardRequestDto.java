package com.example.student.StudentRest.StandardService.DTO;

import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardRequestDto {
    @NotBlank(message = "Student Name is Required")
    private String name;

    private List<Long> studentEntityList;

    @NotNull(message = "Teacher is Required")
    private Long headTeacherId;
}
