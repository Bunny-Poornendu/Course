package com.company.courseapi.repository;

import com.company.courseapi.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
