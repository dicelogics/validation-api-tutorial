package com.dicelogics.tutorial.validation.controller;

import com.dicelogics.tutorial.validation.model.OrderForm;
import com.dicelogics.tutorial.validation.model.PlacedOrder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderRestController {

    @PostMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PlacedOrder submitOrder(@Valid @RequestBody OrderForm orderForm) {
        return new PlacedOrder("order_123");
    }
}
