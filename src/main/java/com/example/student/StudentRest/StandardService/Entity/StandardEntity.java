package com.example.student.StudentRest.StandardService.Entity;

import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "standards")
public class StandardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "standard")
    private List<StudentEntity> studentEntityList;

    @OneToOne
    @JoinColumn(name = "head_teacher_id")
    private TeacherEntity headTeacher;
}
