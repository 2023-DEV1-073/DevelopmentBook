package com.dev.bookshop.services;

import com.dev.bookshop.services.model.*;
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
        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, calculationService.getInvoice(shoppingCart).getTotalPrice());
    }

    @Test
    void calculate5PercentageDiscountFor2DifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo));
        Invoice invoice = calculationService.getInvoice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS, invoice.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_2_BOOK, invoice.getTotalPrice());

        Assert.assertEquals(DISCOUNT_APPLIED_FOR_2_BOOKS, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                 .getDiscountApplied());
        Assert.assertEquals(TWO_BOOKS_IN_A_GROUP.intValue(), invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                    .getBooks()
                                                                    .size());
    }

    @Test
    void calculateTenPercentageDiscountForThreeDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree));
        Invoice invoice = calculationService.getInvoice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_3_BOOKS, invoice.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_3_BOOK, invoice.getTotalPrice());

        Assert.assertEquals(DISCOUNT_APPLIED_FOR_3_BOOKS, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                 .getDiscountApplied());
        Assert.assertEquals(THREE_BOOKS_IN_A_GROUP.intValue(), invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                      .getBooks()
                                                                      .size());
    }

    @Test
    void calculateTwentyPercentageDiscountForFourDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 1);
        DifferentBook bookFour = new DifferentBook(Book.LEGACY_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree, bookFour));
        Invoice invoice = calculationService.getInvoice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_4_BOOKS, invoice.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_4_BOOK, invoice.getTotalPrice());

        Assert.assertEquals(DISCOUNT_APPLIED_FOR_4_BOOKS, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                 .getDiscountApplied());
        Assert.assertEquals(FOUR_BOOKS_IN_A_GROUP.intValue(), invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                     .getBooks()
                                                                     .size());
    }

    @Test
    void calculateTwentyFivePercentageDiscountForFiveDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 1);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 1);
        DifferentBook bookFour = new DifferentBook(Book.LEGACY_CODE, 1);
        DifferentBook bookFive = new DifferentBook(Book.TEST_DRIVEN_DEVELOPMENT, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree, bookFour, bookFive));
        Invoice invoice = calculationService.getInvoice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_5_BOOKS, invoice.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_5_BOOK, invoice.getTotalPrice());

        Assert.assertEquals(DISCOUNT_APPLIED_FOR_5_BOOKS, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                 .getDiscountApplied());
        Assert.assertEquals(FIVE_BOOKS_IN_A_GROUP.intValue(), invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                     .getBooks()
                                                                     .size());
    }

    @Test
    void calculateFivePercentageDiscountForTwoDifferentBooksAndNoDiscountForOneSameBook() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 2);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo));
        Invoice invoice = calculationService.getInvoice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS_AND_1_SAME_BOOK, invoice.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_3_BOOK, invoice.getTotalPrice());

        Assert.assertEquals(TWO.intValue(), invoice.getGroupOfDifferentBooks().size());
        Assert.assertEquals(BOOK_PRICE_FOR_2_BOOK, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                          .getTotalPrice());
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_BOOKS, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                 .getDiscountedPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_2_BOOKS, invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                 .getDiscountApplied());
        Assert.assertEquals(TWO_BOOKS_IN_A_GROUP.intValue(), invoice.getGroupOfDifferentBooks().get(FIRST_GROUP)
                                                                    .getBooks()
                                                                    .size());

        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, invoice.getGroupOfDifferentBooks().get(SECOND_GROUP)
                                                          .getTotalPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_1_BOOK, invoice.getGroupOfDifferentBooks().get(SECOND_GROUP)
                                                          .getDiscountedPrice());
        Assert.assertEquals(DISCOUNT_APPLIED_FOR_1_BOOK, invoice.getGroupOfDifferentBooks().get(SECOND_GROUP)
                                                                .getDiscountApplied());
        Assert.assertEquals(ONE_BOOK_IN_A_GROUP.intValue(), invoice.getGroupOfDifferentBooks().get(SECOND_GROUP)
                                                                   .getBooks()
                                                                   .size());

    }

    @Test
    void calculateTwentyPercentageDiscountForFourDifferentBooksAndAnotherTwentyPercentageDiscountForFourDifferentBooks() {
        DifferentBook bookOne = new DifferentBook(Book.CLEAN_CODER, 2);
        DifferentBook bookTwo = new DifferentBook(Book.CLEAN_CODE, 2);
        DifferentBook bookThree = new DifferentBook(Book.CLEAN_ARCHITECTURE, 2);
        DifferentBook bookFour = new DifferentBook(Book.LEGACY_CODE, 1);
        DifferentBook bookFive = new DifferentBook(Book.TEST_DRIVEN_DEVELOPMENT, 1);
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(bookOne, bookTwo, bookThree, bookFour, bookFive));
        Invoice invoice = calculationService.getInvoice(shoppingCart);
        Assert.assertEquals(DISCOUNTED_PRICE_FOR_2_GROUP_OF_4_BOOKS, invoice.getDiscountedPrice());
        Assert.assertEquals(BOOK_PRICE_FOR_8_BOOK, invoice.getTotalPrice());

        Assert.assertEquals(TWO.intValue(), invoice.getGroupOfDifferentBooks().size());

        for (GroupOfDifferentBook groupOfDifferentBook : invoice.getGroupOfDifferentBooks()) {
            Assert.assertEquals(BOOK_PRICE_FOR_4_BOOK, groupOfDifferentBook.getTotalPrice());
            Assert.assertEquals(DISCOUNTED_PRICE_FOR_4_BOOKS, groupOfDifferentBook.getDiscountedPrice());
            Assert.assertEquals(DISCOUNT_APPLIED_FOR_4_BOOKS, groupOfDifferentBook.getDiscountApplied());
            Assert.assertEquals(FOUR_BOOKS_IN_A_GROUP.intValue(), groupOfDifferentBook.getBooks().size());
        }
    }
}
