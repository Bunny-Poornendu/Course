package com.company.courseapi.dto;

import com.company.courseapi.validation.StarRating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @NotBlank
    private String comment;

    @StarRating
    private Integer rating;

    @NotNull
    private Long userId;

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
