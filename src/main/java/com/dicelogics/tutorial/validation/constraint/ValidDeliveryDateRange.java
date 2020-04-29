package com.dicelogics.tutorial.validation.constraint;

import com.dicelogics.tutorial.validation.validator.DeliveryDateRangeValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DeliveryDateRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDeliveryDateRange {

    String message() default "Wrong delivery date range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

