package com.example.student.StudentRest.StudentService.Entity;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String phoneNumber;

    @Column(nullable = false,unique = true)
    private String rollNumber;

    private int age;

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private StandardEntity standard;
}
