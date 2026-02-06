package com.example.student.StudentRest.StandardService.DTO;

import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseDto {

    private Long id;

    private String name;

    private List<Long> studentEntityList;

    private Long headTeacher;
}
