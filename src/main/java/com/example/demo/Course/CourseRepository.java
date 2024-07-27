package com.example.demo.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findCourseById(String Id);
    List<Course> findCoursesByYearTaught(int yearTaught);
}
