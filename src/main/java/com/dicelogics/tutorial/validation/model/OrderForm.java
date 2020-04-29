package com.dicelogics.tutorial.validation.model;

import com.dicelogics.tutorial.validation.constraint.ValidDeliveryDateRange;
import com.dicelogics.tutorial.validation.constraint.ValidProductId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ValidDeliveryDateRange
public class OrderForm {

    @ValidProductId
    @NotEmpty
    private String productId;

    @NotEmpty
    @Email
    private String userEmail;
    @NotEmpty
    private String name;

    @Valid
    @NotNull
    private DeliveryAddress deliveryAddress;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliveryAfter;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliveryBefore;
}
