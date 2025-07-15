package com.company.courseapi.dto;

public class ReviewResponseDTO {
    private Long id;
    private String comment;
    private Integer rating;
    private String userName;

    public ReviewResponseDTO(Long id, String comment, Integer rating, String userName) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.userName = userName;
    }

    public Long getId() { return id; }
    public String getComment() { return comment; }
    public Integer getRating() { return rating; }
    public String getUserName() { return userName; }
}
