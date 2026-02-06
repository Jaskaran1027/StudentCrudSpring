package com.example.student.StudentRest.TeacherService.Entity;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import com.example.student.StudentRest.SubjectService.Entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class TeacherEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private int age;

    @OneToOne(mappedBy = "headTeacher")
    private StandardEntity assignedClass;

    @ManyToOne
    @JoinColumn(name= "subject_id")
    private SubjectEntity subject;
}
