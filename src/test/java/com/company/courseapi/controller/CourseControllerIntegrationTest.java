package com.company.courseapi.controller;

import com.company.courseapi.model.Course;
import com.company.courseapi.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    public void setup() {
        courseRepository.deleteAll();

        Course course1 = new Course();
        course1.setTitle("Java Basics");
        course1.setInstructor("Prof. Sharma");
        course1.setDescription("Introductory Java Course");

        Course course2 = new Course();
        course2.setTitle("Spring Boot");
        course2.setInstructor("Dr. Mehta");
        course2.setDescription("Advanced Spring Boot Course");

        courseRepository.save(course1);
        courseRepository.save(course2);
    }

    @Test
    public void testGetAllCourses() throws Exception {
        mockMvc.perform(get("/api/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
