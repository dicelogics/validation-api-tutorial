package com.dicelogics.tutorial.validation.constraint;

import com.dicelogics.tutorial.validation.validator.ProductIdValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ProductIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductId {

    String message() default "Wrong product Id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

