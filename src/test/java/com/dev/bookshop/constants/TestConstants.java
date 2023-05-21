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
    public static final Integer NO_OF_UNIQUE_BOOKS = 5;
    public static final Integer DISCOUNT_APPLIED_FOR_2_BOOKS = 5;
    public static final Double BOOK_PRICE_FOR_1_BOOK = 50.0;
    public static final Double BOOK_PRICE_FOR_2_BOOK = 100.0;
    public static final Double DISCOUNTED_PRICE_FOR_2_BOOKS = 95.0;


}
