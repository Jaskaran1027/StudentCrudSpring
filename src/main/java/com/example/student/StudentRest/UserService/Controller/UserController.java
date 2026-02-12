package com.example.student.StudentRest.UserService.Controller;

import com.example.student.StudentRest.TeacherService.DTO.TeacherRequestDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherResponseDto;
import com.example.student.StudentRest.UserService.DTO.UserRequestDto;
import com.example.student.StudentRest.UserService.DTO.UserResponseDto;
import com.example.student.StudentRest.UserService.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser( @Valid @RequestBody UserRequestDto userRequestDto){
        UserResponseDto response =
                userService.createUser(userRequestDto);

        return ResponseEntity.ok(response);
    }
}
