package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentsByEmail(String email );
    Optional<Student> findStudentById(Long id);
}
