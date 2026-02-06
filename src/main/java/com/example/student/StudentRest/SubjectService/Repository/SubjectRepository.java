package com.example.student.StudentRest.SubjectService.Repository;

import com.example.student.StudentRest.SubjectService.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
