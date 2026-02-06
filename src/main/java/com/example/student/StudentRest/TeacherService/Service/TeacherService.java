package com.example.student.StudentRest.TeacherService.Service;

import com.example.student.StudentRest.SubjectService.Entity.SubjectEntity;
import com.example.student.StudentRest.SubjectService.Repository.SubjectRepository;
import com.example.student.StudentRest.TeacherService.DTO.TeacherRequestDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherResponseDto;
import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import com.example.student.StudentRest.TeacherService.Repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public TeacherResponseDto createTeacher(TeacherRequestDto teacherData){
        TeacherEntity newTeacher= new TeacherEntity();
        newTeacher.setName(teacherData.getName());
        newTeacher.setAge(teacherData.getAge());
        newTeacher.setPhoneNumber(teacherData.getPhoneNumber());

        if(teacherData.getSubjectId() != null){
            SubjectEntity subject=subjectRepository.findById(teacherData.getSubjectId()).orElseThrow(() -> new RuntimeException("Subject not found"));
            newTeacher.setSubject(subject);
        }

        teacherRepository.save(newTeacher);

        TeacherResponseDto teacherResponse= new TeacherResponseDto();
        teacherResponse.setName(newTeacher.getName());
        teacherResponse.setAge(newTeacher.getAge());
        teacherResponse.setId(newTeacher.getId());
        teacherResponse.setPhoneNumber(newTeacher.getPhoneNumber());

        if(newTeacher.getSubject() != null){
            teacherResponse.setSubjectId(newTeacher.getSubject().getId());
        }

        return teacherResponse;
    }
}
