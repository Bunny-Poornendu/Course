package com.company.courseapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.company.courseapi.validation.StarRating;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String comment;

    @StarRating
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference(value = "course-reviews")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-reviews")
    private User user;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
