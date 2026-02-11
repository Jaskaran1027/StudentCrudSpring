package com.example.student.StudentRest.StudentService.Service;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import com.example.student.StudentRest.StandardService.Repository.StandardRepository;
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

    @Autowired
    private StandardRepository standardRepository;

    public StudentResponseDto createStudent(StudentRequestDto studentData){
        StudentEntity newStudent=new StudentEntity();
        newStudent.setName((studentData.getName()));
        newStudent.setAge(studentData.getAge());
        newStudent.setPhoneNumber(studentData.getPhoneNumber());
        newStudent.setRollNumber(studentData.getRollNumber());
        if(studentData.getStandardId() != null){
            StandardEntity standardEntity = standardRepository.findById(studentData.getStandardId()).orElseThrow(()-> new RuntimeException("Standard not found"));
            newStudent.setStandard(standardEntity);
        }
        studentRepository.save(newStudent);

        Long standardId = newStudent.getStandard() != null
                ? newStudent.getStandard().getId()
                : null;

        StudentResponseDto studentResponseData=new StudentResponseDto(newStudent.getId(), newStudent.getName(), newStudent.getPhoneNumber(),newStudent.getRollNumber(),newStudent.getAge(),standardId);

        return studentResponseData;
    }
}
