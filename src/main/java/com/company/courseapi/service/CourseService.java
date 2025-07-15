package com.company.courseapi.service;

import com.company.courseapi.dto.CourseResponseDTO;
import com.company.courseapi.model.Course;
import com.company.courseapi.model.Review;
import com.company.courseapi.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Iterable<CourseResponseDTO> getAllCoursesWithRatings() {
        return courseRepository.findAllWithAverageRating();
    }
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
}
