package com.example.student.StudentRest.UserService.Service;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import com.example.student.StudentRest.StandardService.Repository.StandardRepository;
import com.example.student.StudentRest.StudentService.DTO.StudentRequestDto;
import com.example.student.StudentRest.StudentService.DTO.StudentResponseDto;
import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import com.example.student.StudentRest.StudentService.Repository.StudentRepository;
import com.example.student.StudentRest.SubjectService.Entity.SubjectEntity;
import com.example.student.StudentRest.SubjectService.Repository.SubjectRepository;
import com.example.student.StudentRest.TeacherService.DTO.TeacherRequestDto;
import com.example.student.StudentRest.TeacherService.DTO.TeacherResponseDto;
import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import com.example.student.StudentRest.TeacherService.Repository.TeacherRepository;
import com.example.student.StudentRest.UserService.DTO.UserRequestDto;
import com.example.student.StudentRest.UserService.DTO.UserResponseDto;
import com.example.student.StudentRest.UserService.Entity.UserEntity;
import com.example.student.StudentRest.UserService.Enum.Role;
import com.example.student.StudentRest.UserService.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StandardRepository standardRepository;

    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();;


@Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto){

        //Save user entity
        UserEntity user= new UserEntity();
        String encryptedPassword=passwordEncoder.encode(userRequestDto.getPassword());
        user.setUserName(userRequestDto.getUserName());
        user.setPassword(encryptedPassword);
        user.setRole(userRequestDto.getRole());
        userRepository.save(user);

        //Save Teacher Entity
        TeacherResponseDto teacherResponse= new TeacherResponseDto();
        StudentResponseDto studentResponseData = new StudentResponseDto();
        if(user.getRole() == Role.TEACHER){

            TeacherRequestDto teacherData=userRequestDto.getTeacher();

            //Teacher Entity
            TeacherEntity newTeacher= new TeacherEntity();
            newTeacher.setName(teacherData.getName());
            newTeacher.setAge(teacherData.getAge());
            newTeacher.setPhoneNumber(teacherData.getPhoneNumber());
            newTeacher.setUser(user);

            if(teacherData.getSubjectId() != null){
                SubjectEntity subject=subjectRepository.findById(teacherData.getSubjectId()).orElseThrow(() -> new RuntimeException("Subject not found"));
                newTeacher.setSubject(subject);
            }

            teacherRepository.save(newTeacher);

            //Teacher Response
            teacherResponse.setName(newTeacher.getName());
            teacherResponse.setAge(newTeacher.getAge());
            teacherResponse.setId(newTeacher.getId());
            teacherResponse.setPhoneNumber(newTeacher.getPhoneNumber());

            if(newTeacher.getSubject() != null){
                teacherResponse.setSubjectId(newTeacher.getSubject().getId());
            }

        }

        if(user.getRole() == Role.STUDENT){
            StudentRequestDto studentData = userRequestDto.getStudent();

            //Entity
            StudentEntity newStudent=new StudentEntity();
            newStudent.setName((studentData.getName()));
            newStudent.setAge(studentData.getAge());
            newStudent.setPhoneNumber(studentData.getPhoneNumber());
            newStudent.setRollNumber(studentData.getRollNumber());
            newStudent.setUser(user);

            if(studentData.getStandardId() != null){
                StandardEntity standardEntity = standardRepository.findById(studentData.getStandardId()).orElseThrow(()-> new RuntimeException("Standard not found"));
                newStudent.setStandard(standardEntity);
            }
            studentRepository.save(newStudent);

            Long standardId = newStudent.getStandard() != null
                    ? newStudent.getStandard().getId()
                    : null;

            //Student Response
            studentResponseData.setId(newStudent.getId());
            studentResponseData.setName(newStudent.getName());
            studentResponseData.setAge(newStudent.getAge());
            studentResponseData.setPhoneNumber(newStudent.getPhoneNumber());
            studentResponseData.setRollNumber(newStudent.getRollNumber());
            studentResponseData.setStandardId(standardId);

        }

        UserResponseDto userResponse= UserResponseDto.builder().id(user.getId()).role(user.getRole()).userName(user.getUserName()).build();

    if (user.getRole() == Role.TEACHER) {
        userResponse.setTeacher(teacherResponse);
    } else {
        userResponse.setStudent(studentResponseData);
    }


    return userResponse;
    }
}
