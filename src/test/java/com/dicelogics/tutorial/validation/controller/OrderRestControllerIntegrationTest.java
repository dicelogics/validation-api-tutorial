package com.dicelogics.tutorial.validation.controller;

import org.assertj.core.util.Lists;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@AutoConfigureMockMvc
public class OrderRestControllerIntegrationTest {

    @Autowired
    private OrderRestController orderRestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBadRequestWhenPostedWrongEmailAddress() throws Exception {
        String request = "{" +
                "\"productId\": \"PROD-4565\"," +
                "    \"userEmail\": \"wrong email value\"," +
                "    \"name\": \"A\"," +
                "    \"deliveryAddress\": {" +
                "       \"city\": \"Los Angeles\"," +
                "       \"line\": \"Aviation Blvd.\"," +
                "       \"zip\": \"4056\" " +
                "    }," +
                "    \"deliveryAfter\": \"2020-06-01\"," +
                "    \"deliveryBefore\": \"2020-06-05\"" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.errors.userEmail[*].message",
                        Is.is(Lists.list("must be a well-formed email address"))))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON));
    }
}
