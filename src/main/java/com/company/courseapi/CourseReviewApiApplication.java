package com.company.courseapi;

import com.company.courseapi.model.Course;
import com.company.courseapi.model.User;
import com.company.courseapi.repository.CourseRepository;
import com.company.courseapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CourseReviewApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseReviewApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepository, CourseRepository courseRepository) {
        return args -> {
            // Mock Users
            User user1 = new User();
            user1.setId(1L);
            user1.setName("Alice");

            User user2 = new User();
            user2.setId(2L);
            user2.setName("Bob");

            userRepository.save(user1);
            userRepository.save(user2);

            // Only add courses if none exist
            if (courseRepository.count() == 0) {
                List<Course> mockCourses = List.of(
                        new Course(null, "React for Beginners", "Learn the basics of React", "Bunny", new ArrayList<>()),
                        new Course(null, "Advanced Java", "Deep dive into Java and JVM internals", "Iqbal", new ArrayList<>()),
                        new Course(null, "Spring Boot Essentials", "Build modern APIs with Spring Boot", "Aarav", new ArrayList<>()),
                        new Course(null, "Fullstack with MERN", "MongoDB, Express, React, Node", "Neha", new ArrayList<>()),
                        new Course(null, "DevOps Toolkit", "CI/CD with Jenkins, Docker, and K8s", "Iqbal", new ArrayList<>()),
                        new Course(null, "Data Structures", "Master DSA for interviews", "Riya", new ArrayList<>()),
                        new Course(null, "System Design", "High-level scalable architecture", "Raj", new ArrayList<>()),
                        new Course(null, "Python Crash Course", "Python basics to advanced", "Diya", new ArrayList<>()),
                        new Course(null, "AWS Fundamentals", "Deploy apps on AWS", "Vikram", new ArrayList<>()),
                        new Course(null, "Machine Learning 101", "Intro to ML and scikit-learn", "Meena", new ArrayList<>()),
                        new Course(null, "Database Design", "Normalize, index, and optimize DBs", "Kunal", new ArrayList<>()),
                        new Course(null, "Kubernetes in Action", "Deploy microservices with K8s", "Asha", new ArrayList<>()),
                        new Course(null, "Linux for Developers", "Shell scripting, commands, permissions", "Siddharth", new ArrayList<>()),
                        new Course(null, "Networking Basics", "TCP/IP, HTTP, DNS explained", "Arjun", new ArrayList<>()),
                        new Course(null, "Clean Code Principles", "Write readable and maintainable code", "Sneha", new ArrayList<>())
                );

                courseRepository.saveAll(mockCourses);
            }
        };
    }
}

