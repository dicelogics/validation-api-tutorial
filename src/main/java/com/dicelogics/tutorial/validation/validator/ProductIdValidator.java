package com.dicelogics.tutorial.validation.validator;

import com.dicelogics.tutorial.validation.constraint.ValidProductId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductIdValidator implements ConstraintValidator<ValidProductId, String> {

    @Override
    public boolean isValid(String productId, ConstraintValidatorContext context) {
        return productId != null && productId.matches("PROD-\\d{4}");
    }
}
