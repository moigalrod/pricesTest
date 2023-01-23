package com.inditex.test.aplication.common;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;

public interface IValidationService<E> {
    default void validations(E entity) {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        var violations = validator.validate(entity);

        if (!violations.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<E> constraintViolation : violations) {
                message.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException(message.toString(), violations);
        }
    }
}
