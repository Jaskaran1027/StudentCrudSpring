package com.example.student.StudentRest.StudentService.Entity;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import com.example.student.StudentRest.UserService.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
