package com.example.demo.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @GetMapping(path = "{courseId}")
    public Optional<Course> getCourseById(@PathVariable("courseId") String courseId){
        return courseService.getCourseByIdOrName(courseId);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourses(course);
    }

    @GetMapping(path = "year/{courseYear}")
    public List<Course> getCourseByYear(@PathVariable("courseYear") Integer courseYear){
        List<Course> courses = courseService.getCoursesByYear(courseYear);
        return courses;
    }
}
