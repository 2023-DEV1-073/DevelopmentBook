package com.dev.bookshop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShoppingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldGet200ResponseForBookApi() throws Exception {
        mvc.perform(get("/api/books/"))
           .andExpect(status().isOk());
    }
}
