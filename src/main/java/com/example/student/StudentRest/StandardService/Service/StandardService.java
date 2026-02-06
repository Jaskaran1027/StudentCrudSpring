package com.example.student.StudentRest.StandardService.Service;

import com.example.student.StudentRest.StandardService.DTO.StandardRequestDto;
import com.example.student.StudentRest.StandardService.DTO.StandardResponseDto;
import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import com.example.student.StudentRest.StandardService.Repository.StandardRepository;
import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import com.example.student.StudentRest.TeacherService.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardService {

    @Autowired
    private StandardRepository standardRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public StandardResponseDto createStandard(StandardRequestDto standardData){
        StandardEntity newStandard=new StandardEntity();
        newStandard.setName(standardData.getName());

        TeacherEntity headTeacher=teacherRepository.findById(standardData.getHeadTeacherId()).orElseThrow(()-> new RuntimeException("Teacher not found"));

        newStandard.setHeadTeacher(headTeacher);
        standardRepository.save(newStandard);
        StandardResponseDto standardResponse = new StandardResponseDto();

        standardResponse.setId(newStandard.getId());
        standardResponse.setName(newStandard.getName());
        standardResponse.setHeadTeacher(newStandard.getHeadTeacher().getId());

        return standardResponse;
    }
}
