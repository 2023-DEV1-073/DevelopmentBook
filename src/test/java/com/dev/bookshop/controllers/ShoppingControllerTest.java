package com.dev.bookshop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.dev.bookshop.constants.TestConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    void shouldGet200ResponseForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice/").content("{\"isbn\": [12345] }")
                                                .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isOk());
    }

    @Test
    void shouldGet404ResponseWhenWrongISBNPassedForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{\"isbn\": [123456666] }")
                                               .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isNotFound())
           .andExpect(content().string(ISBN_NOT_FOUND_ERROR_JSON));
    }

    @Test
    void shouldGet400ResponseWhenEmptyRequestPassedForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{}").contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isBadRequest())
           .andExpect(content().string(EMPTY_CART_ERROR_JSON));
    }

    @Test
    void shouldGet400ResponseWhenDuplicateBooksPassedForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{\"isbn\": [12345, 12345] }")
                                               .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isBadRequest())
           .andExpect(content().string(DUPLICATE_BOOK_ENTRY_ERROR_JSON));
    }

}
