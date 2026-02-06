package com.example.student.StudentRest.StandardService.Repository;

import com.example.student.StudentRest.StandardService.Entity.StandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardRepository extends JpaRepository<StandardEntity,Long> {
}
