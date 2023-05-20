package com.dev.bookshop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.dev.bookshop.constants.TestConstants.ALL_BOOK_DETAILS_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    @Test
    void shouldGetAllBookDetailsForBookApi() throws Exception {
        mvc.perform(get("/api/books/"))
           .andExpect(content().json(ALL_BOOK_DETAILS_JSON));
    }

}
