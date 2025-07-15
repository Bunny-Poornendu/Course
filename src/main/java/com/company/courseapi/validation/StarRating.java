package com.company.courseapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StarRatingValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StarRating {
    String message() default "Rating must be between 1 and 5";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
