package com.example.student.StudentRest.StandardService.Controller;

import com.example.student.StudentRest.StandardService.DTO.StandardRequestDto;
import com.example.student.StudentRest.StandardService.DTO.StandardResponseDto;
import com.example.student.StudentRest.StandardService.Service.StandardService;
import com.example.student.StudentRest.TeacherService.DTO.TeacherRequestDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/standard")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> createStandard(
            @Valid @RequestBody StandardRequestDto standardRequestDto
    ){
        StandardResponseDto response =
                standardService.createStandard(standardRequestDto);

        return ResponseEntity.ok(response);
    }
}
