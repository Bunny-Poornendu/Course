package com.company.courseapi.dto;

public class CourseResponseDTO {
    private Long id;
    private String title;
    private String instructor;
    private Double averageRating;

    public CourseResponseDTO(Long id, String title, String instructor, Double averageRating) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.averageRating = averageRating;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public Double getAverageRating() { return averageRating; }
}
