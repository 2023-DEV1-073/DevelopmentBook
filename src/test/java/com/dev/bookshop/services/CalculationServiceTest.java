package com.dev.bookshop.services;

import com.dev.bookshop.services.model.Book;
import com.dev.bookshop.services.model.Price;
import com.dev.bookshop.services.model.ShoppingCart;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

import static com.dev.bookshop.constants.TestConstants.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CalculationServiceTest {

    @Autowired
    CalculationService calculationService;

    @Test
    void calculateBookPriceFor1Book() {
        ShoppingCart shoppingCart = new ShoppingCart(Collections.singletonList(Book.CLEAN_CODE));
        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, calculationService.getPrice(shoppingCart).getTotalPrice());
    }

    @Test
    void calculate5PercentageDiscountFor2DifferentBooks() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(Book.CLEAN_CODER, Book.CLEAN_CODE));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_2_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_2_BOOKS, price.getDiscountApplied());
    }

    @Test
    void calculateTenPercentageDiscountForThreeDifferentBooks() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(Book.CLEAN_CODER, Book.CLEAN_CODE, Book.CLEAN_ARCHITECTURE));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_3_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_3_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_3_BOOKS, price.getDiscountApplied());
    }

}
