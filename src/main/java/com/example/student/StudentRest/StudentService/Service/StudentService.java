package com.example.student.StudentRest.StudentService.Service;

import com.example.student.StudentRest.StudentService.DTO.StudentRequestDto;
import com.example.student.StudentRest.StudentService.DTO.StudentResponseDto;
import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import com.example.student.StudentRest.StudentService.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
   @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponseDto createStudent(StudentRequestDto studentData){
        StudentEntity newStudent=modelMapper.map(studentData,StudentEntity.class);
        studentRepository.save(newStudent);
        StudentResponseDto responseStudent=modelMapper.map(newStudent,StudentResponseDto.class);
        return responseStudent;
    }
}
