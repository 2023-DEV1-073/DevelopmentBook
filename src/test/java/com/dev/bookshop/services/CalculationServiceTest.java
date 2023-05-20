package com.dev.bookshop.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.dev.bookshop.constants.TestConstants.BOOK_PRICE_FOR_1_BOOK;
import static com.dev.bookshop.constants.TestConstants.ISBN_FOR_CLEAN_CODE_BOOK;

@SpringBootTest
@RunWith(SpringRunner.class)
class CalculationServiceTest {

    @Autowired
    CalculationService calculationService;

    @Test
    void calculateBookPriceFor1Book() {
        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, calculationService.getPrice(ISBN_FOR_CLEAN_CODE_BOOK));
    }
}
