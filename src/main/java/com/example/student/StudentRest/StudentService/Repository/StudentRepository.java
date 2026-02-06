package com.example.student.StudentRest.StudentService.Repository;

import com.example.student.StudentRest.StudentService.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
