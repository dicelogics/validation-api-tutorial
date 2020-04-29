package com.dicelogics.tutorial.validation.validator;

import com.dicelogics.tutorial.validation.constraint.ValidDeliveryDateRange;
import com.dicelogics.tutorial.validation.model.OrderForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DeliveryDateRangeValidator implements ConstraintValidator<ValidDeliveryDateRange, OrderForm> {

    @Override
    public boolean isValid(OrderForm value, ConstraintValidatorContext context) {
        boolean isValid = true;
        Date deliveryAfter = value.getDeliveryAfter();
        Date deliveryBefore = value.getDeliveryBefore();

        if (deliveryAfter == null || deliveryBefore == null) {
            isValid = false;
        } else if (deliveryAfter.getTime() > deliveryBefore.getTime()) {
            isValid = false;
        }
        return isValid;
    }
}
