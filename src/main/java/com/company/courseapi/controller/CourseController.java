package com.company.courseapi.controller;

import com.company.courseapi.dto.CourseResponseDTO;
import com.company.courseapi.model.Course;
import com.company.courseapi.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public Iterable<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCoursesWithRatings();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping(consumes = "application/json")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
}
