package com.example.student.StudentRest.UserService.DTO;

import com.example.student.StudentRest.StudentService.DTO.StudentRequestDto;
import com.example.student.StudentRest.StudentService.DTO.StudentResponseDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherRequestDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherResponseDto;
import com.example.student.StudentRest.UserService.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;

    private String userName;

//    @Pattern(
//            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
//            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character (@$!%*?&)"
//    )
//    @NotBlank(message = "Password is required")
//    private String password;

    private Role role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StudentResponseDto student;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TeacherResponseDto teacher;
}
