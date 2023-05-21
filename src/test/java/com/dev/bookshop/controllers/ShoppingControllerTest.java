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
        mvc.perform(post("/api/calculatePrice/").content("{\"bookOrders\":[{ \"isbn\": \"12345\",\"quantity\":1}]}")
                                                .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isOk());
    }

    @Test
    void shouldGet404ResponseWhenWrongISBNPassedForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{\"bookOrders\":[{ \"isbn\": \"123456666\",\"quantity\":1}]}")
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
        mvc.perform(post("/api/calculatePrice").content("{\"bookOrders\":[{ \"isbn\": \"12345\",\"quantity\":1},{ \"isbn\": \"12345\",\"quantity\":1}]}")
                                               .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isBadRequest())
           .andExpect(content().string(DUPLICATE_BOOK_ENTRY_ERROR_JSON));
    }

    @Test
    void shouldGet400ResponseWhenISBNNotPassedForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{\"bookOrders\":[{ \"quantity\":1}]}")
                                               .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isBadRequest())
           .andExpect(content().string(ISBN_MISSING_ERROR_JSON));
    }

    @Test
    void shouldGet400ResponseWhenQuantityNotPassedForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{\"bookOrders\":[{ \"isbn\":\"12345\"}]}")
                                               .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isBadRequest())
           .andExpect(content().string(QUANTITY_MISSING_ERROR_JSON));
    }

    @Test
    void shouldGetInvoiceResponseForPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice/").content("{\"bookOrders\":[{ \"isbn\": \"12345\",\"quantity\":2}]}")
                                                .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isOk()).andExpect(content().string(INVOICE_RESPONSE_FOR_ONE_BOOK_TWO_QUANTITY));
    }

    @Test
    void shouldGet400ResponseWhenQuantityPassedAsLessThanMinimumToPriceApi() throws Exception {
        mvc.perform(post("/api/calculatePrice").content("{\"bookOrders\":[{ \"isbn\":\"12345\",\"quantity\":0}]}")
                                               .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isBadRequest())
           .andExpect(content().string(MINIMUM_BOOK_QUANTITY_ERROR_JSON));
    }

}
