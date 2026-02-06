package com.example.student.StudentRest.TeacherService.Repository;

import com.example.student.StudentRest.TeacherService.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<TeacherEntity , Long> {
}
