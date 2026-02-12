package com.example.student.StudentRest.UserService.Repository;

import com.example.student.StudentRest.UserService.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long> {

}
