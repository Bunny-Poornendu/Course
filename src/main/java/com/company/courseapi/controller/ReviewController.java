package com.company.courseapi.controller;

import com.company.courseapi.dto.ReviewRequestDTO;
import com.company.courseapi.model.Review;
import com.company.courseapi.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/courses/{courseId}/reviews")
    public Review createReview(@PathVariable Long courseId, @RequestBody @Valid ReviewRequestDTO dto) {
        return reviewService.createReview(courseId, dto);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
