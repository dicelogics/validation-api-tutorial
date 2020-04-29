package com.dicelogics.tutorial.validation.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeliveryAddress {
    @NotEmpty
    private String city;
    @NotEmpty
    private String line;
    @NotEmpty
    private String zip;
}
