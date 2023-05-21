package com.dev.bookshop.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestConstants {
    public static final List<String> COLLECTION_OF_ISBN = Arrays.asList("12345", "23451", "34512", "45123", "51234");
    public static final String ALL_BOOK_DETAILS_JSON = "[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"yearOfPublish\":\"2008\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"The Clean Coder\",\"isbn\":\"23451\",\"yearOfPublish\":\"2011\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Clean Architecture\",\"isbn\":\"34512\",\"yearOfPublish\":\"2017\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Test Driven Development by Example\",\"isbn\":\"45123\",\"yearOfPublish\":\"2003\",\"price\":\"50\",\"authorName\":\"Kent Beck\"},{\"title\":\"Working Effectively With Legacy Code\",\"isbn\":\"51234\",\"yearOfPublish\":\"2004\",\"price\":\"50\",\"authorName\":\"Michael C. Feathers\"}]> but was:<[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"yearOfPublish\":\"2008\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"The Clean Coder\",\"isbn\":\"23451\",\"yearOfPublish\":\"2011\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Clean Architecture\",\"isbn\":\"34512\",\"yearOfPublish\":\"2017\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Test Driven Development by Example\",\"isbn\":\"45123\",\"yearOfPublish\":\"2003\",\"price\":\"50\",\"authorName\":\"Kent Beck\"},{\"title\":\"Working Effectively With Legacy Code\",\"isbn\":\"51234\",\"yearOfPublish\":\"2004\",\"price\":\"50\",\"authorName\":\"Michael C. Feathers\"}]";
    public static final String ISBN_NOT_FOUND_ERROR_JSON = "{\"message\":\"Requested ISBN not found/ISBN is null, Try again with valid ISBN \"}";
    public static final String EMPTY_CART_ERROR_JSON = "{\"message\":\"Cart is Empty, add items and request again\"}";
    public static final String DUPLICATE_BOOK_ENTRY_ERROR_JSON = "{\"message\":\"There are duplicate ISBN 12345, Remove it and request again\"}";
    public static final String ISBN_MISSING_ERROR_JSON = "{\"message\":\"ISBN is mandatory detail, Add detail and request again\"}";
    public static final String QUANTITY_MISSING_ERROR_JSON = "{\"message\":\"Quantity is mandatory detail, Add detail and request again\"}";
    public static final String INVOICE_RESPONSE_FOR_ONE_BOOK_TWO_QUANTITY = "{\"groupOfDifferentBooks\":[{\"books\":[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"authorName\":\"Robert Martin\",\"yearOfPublish\":\"2008\",\"price\":\"50\"}],\"discountApplied\":\"0\",\"totalPrice\":\"50.0\",\"discountedPrice\":\"50.0\"},{\"books\":[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"authorName\":\"Robert Martin\",\"yearOfPublish\":\"2008\",\"price\":\"50\"}],\"discountApplied\":\"0\",\"totalPrice\":\"50.0\",\"discountedPrice\":\"50.0\"}],\"totalPrice\":\"100.0\",\"discountedPrice\":\"100.0\"}";
    public static final String MINIMUM_BOOK_QUANTITY_ERROR_JSON = "{\"message\":\"Minimum 1 quantity required per order, Check and request again\"}";
    public static final Integer NO_OF_UNIQUE_BOOKS = 5;
    public static final Integer DISCOUNT_APPLIED_FOR_1_BOOK = 0;
    public static final Integer DISCOUNT_APPLIED_FOR_2_BOOKS = 5;
    public static final Integer DISCOUNT_APPLIED_FOR_3_BOOKS = 10;
    public static final Integer DISCOUNT_APPLIED_FOR_4_BOOKS = 20;
    public static final Integer DISCOUNT_APPLIED_FOR_5_BOOKS = 25;
    public static final Integer ONE_BOOK_IN_A_GROUP = 1;
    public static final Integer TWO_BOOKS_IN_A_GROUP = 2;
    public static final Integer THREE_BOOKS_IN_A_GROUP = 3;
    public static final Integer FOUR_BOOKS_IN_A_GROUP = 4;
    public static final Integer FIVE_BOOKS_IN_A_GROUP = 5;
    public static final Integer FIRST_GROUP = 0;
    public static final Integer SECOND_GROUP = 1;
    public static final Integer TWO = 2;
    public static final Double BOOK_PRICE_FOR_1_BOOK = 50.0;
    public static final Double BOOK_PRICE_FOR_2_BOOK = 100.0;
    public static final Double BOOK_PRICE_FOR_3_BOOK = 150.0;
    public static final Double BOOK_PRICE_FOR_4_BOOK = 200.0;
    public static final Double BOOK_PRICE_FOR_5_BOOK = 250.0;
    public static final Double BOOK_PRICE_FOR_8_BOOK = 400.0;
    public static final Double DISCOUNTED_PRICE_FOR_2_BOOKS = 95.0;
    public static final Double DISCOUNTED_PRICE_FOR_3_BOOKS = 135.0;
    public static final Double DISCOUNTED_PRICE_FOR_4_BOOKS = 160.0;
    public static final Double DISCOUNTED_PRICE_FOR_5_BOOKS = 187.5;
    public static final Double DISCOUNTED_PRICE_FOR_2_BOOKS_AND_1_SAME_BOOK = 145.0;
    public static final Double DISCOUNTED_PRICE_FOR_2_GROUP_OF_4_BOOKS = 320.0;


}
