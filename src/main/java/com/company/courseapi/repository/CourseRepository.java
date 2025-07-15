package com.company.courseapi.repository;

import com.company.courseapi.dto.CourseResponseDTO;
import com.company.courseapi.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query("SELECT new com.company.courseapi.dto.CourseResponseDTO(c.id, c.title, c.instructor, AVG(r.rating)) " +
           "FROM Course c LEFT JOIN c.reviews r GROUP BY c.id, c.title, c.instructor")
    List<CourseResponseDTO> findAllWithAverageRating();
}
