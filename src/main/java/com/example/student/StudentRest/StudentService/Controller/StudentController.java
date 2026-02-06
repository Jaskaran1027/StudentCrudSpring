package com.example.student.StudentRest.StudentService.Controller;

import com.example.student.StudentRest.StudentService.DTO.StudentRequestDto;
import com.example.student.StudentRest.StudentService.DTO.StudentResponseDto;
import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import com.example.student.StudentRest.StudentService.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentRequestDto newStudentData){
    StudentResponseDto newStudent=studentService.createStudent(newStudentData);
    return ResponseEntity.ok(newStudent);
    }

}
