package com.example.demo.repository;

import com.example.demo.model.entity.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<StudentModel, Long> {
    @Query("SELECT s FROM StudentModel s WHERE s.email=?1")
    Optional<StudentModel> findStudentByEmail(String email);
}
