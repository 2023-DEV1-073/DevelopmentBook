package com.dev.bookshop.services;

import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.services.model.Price;
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setIsbn(Collections.singletonList(ISBN_FOR_CLEAN_CODE_BOOK));
        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, calculationService.getPrice(shoppingCart).getTotalPrice());
    }

    @Test
    void calculateFivePercentageDiscountForTwoDifferentBooks() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setIsbn(Arrays.asList(ISBN_FOR_CLEAN_CODER_BOOK, ISBN_FOR_CLEAN_CODE_BOOK));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_2_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_2_BOOKS, price.getDiscountApplied());
    }
}
