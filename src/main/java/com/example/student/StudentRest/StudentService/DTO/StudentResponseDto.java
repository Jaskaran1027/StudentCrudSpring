package com.example.student.StudentRest.StudentService.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

//    @NotNull(message = "Student Id is Required")
    private Long id;

//    @NotBlank(message = "Student Name is Required")
    private String name;

    private String phoneNumber;

//    @NotBlank(message = "Roll number is required")
    private String rollNumber;

//    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

}
