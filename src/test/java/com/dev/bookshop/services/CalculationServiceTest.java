package com.dev.bookshop.services;

import com.dev.bookshop.services.model.Book;
import com.dev.bookshop.services.model.DifferentBook;
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
        DifferentBook differentBook = new DifferentBook(Book.CLEAN_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Collections.singletonList(differentBook));
        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, calculationService.getPrice(shoppingCart).getTotalPrice());
    }

    @Test
    void calculate5PercentageDiscountFor2DifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_2_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_2_BOOKS, price.getDiscountApplied());
    }

    @Test
    void calculateTenPercentageDiscountForThreeDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_3_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_3_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_3_BOOKS, price.getDiscountApplied());
    }

    @Test
    void calculateTwentyPercentageDiscountForFourDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 1);
        DifferentBook bookFour = new DifferentBook(Book.LEGACY_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree, bookFour));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_4_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_4_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_4_BOOKS, price.getDiscountApplied());
    }

    @Test
    void calculateTwentyFivePercentageDiscountForFiveDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 1);
        DifferentBook bookFour = new DifferentBook(Book.LEGACY_CODE, 1);
        DifferentBook bookFive = new DifferentBook(Book.TEST_DRIVEN_DEVELOPMENT, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree, bookFour, bookFive));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_5_BOOKS, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_5_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_5_BOOKS, price.getDiscountApplied());
    }

    @Test
    void calculateFivePercentageDiscountForTwoDifferentBooksAndNoDiscountForOneSameBook() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 2);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo));
        Price price = calculationService.getPrice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS_AND_1_SAME_BOOK, price.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_3_BOOK, price.getTotalPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_2_BOOKS, price.getDiscountApplied());
    }

}
