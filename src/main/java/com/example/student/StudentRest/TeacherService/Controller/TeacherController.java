package com.example.student.StudentRest.TeacherService.Controller;

import com.example.student.StudentRest.TeacherService.DTO.TeacherRequestDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherResponseDto;
import com.example.student.StudentRest.TeacherService.Service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // CREATE TEACHER
    @PostMapping
    public ResponseEntity<TeacherResponseDto> createTeacher(
            @Valid @RequestBody TeacherRequestDto teacherRequestDto
    ){
        TeacherResponseDto response =
                teacherService.createTeacher(teacherRequestDto);

        return ResponseEntity.ok(response);
    }
}
