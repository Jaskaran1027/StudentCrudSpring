package com.example.student.StudentRest.SubjectService.Entity;

import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject")
    private List<TeacherEntity> assignedTeachers;
}
