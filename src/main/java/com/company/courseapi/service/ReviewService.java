package com.company.courseapi.service;

import com.company.courseapi.dto.ReviewRequestDTO;
import com.company.courseapi.model.Course;
import com.company.courseapi.model.Review;
import com.company.courseapi.model.User;
import com.company.courseapi.repository.CourseRepository;
import com.company.courseapi.repository.ReviewRepository;
import com.company.courseapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         CourseRepository courseRepository,
                         UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Review createReview(Long courseId, ReviewRequestDTO dto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Review review = new Review();
        review.setCourse(course);
        review.setUser(user);
        review.setComment(dto.getComment());
        review.setRating(dto.getRating());

        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
