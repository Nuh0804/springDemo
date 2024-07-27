package com.example.demo.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public Optional<Course> getCourseByIdOrName(String courseId) {
            return courseRepository.findById(courseId);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course createCourses(Course course) {
        System.out.println(course);
        Optional<Course> courseById = courseRepository.findById(course.getId());
        if (courseById.isPresent()){
            throw new IllegalStateException("course available already");
        }
        courseRepository.save(course);
        return course;
    }

    public List<Course> getCoursesByYear(int courseYear) {
        return courseRepository.findCoursesByYearTaught(courseYear);
    }
}
