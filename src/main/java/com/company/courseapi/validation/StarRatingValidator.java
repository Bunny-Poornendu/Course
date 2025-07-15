package com.company.courseapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StarRatingValidator implements ConstraintValidator<StarRating, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value >= 1 && value <= 5;
    }
}
