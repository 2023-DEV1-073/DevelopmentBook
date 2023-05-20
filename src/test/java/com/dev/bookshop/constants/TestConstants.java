package com.dev.bookshop.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestConstants {

    public static final List<String> COLLECTION_OF_ISBN = Arrays.asList("12345", "23451", "34512", "45123", "51234");
    public static final String ALL_BOOK_DETAILS_JSON = "[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"yearOfPublish\":\"2008\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"The Clean Coder\",\"isbn\":\"23451\",\"yearOfPublish\":\"2011\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Clean Architecture\",\"isbn\":\"34512\",\"yearOfPublish\":\"2017\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Test Driven Development by Example\",\"isbn\":\"45123\",\"yearOfPublish\":\"2003\",\"price\":\"50\",\"authorName\":\"Kent Beck\"},{\"title\":\"Working Effectively With Legacy Code\",\"isbn\":\"51234\",\"yearOfPublish\":\"2004\",\"price\":\"50\",\"authorName\":\"Michael C. Feathers\"}]> but was:<[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"yearOfPublish\":\"2008\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"The Clean Coder\",\"isbn\":\"23451\",\"yearOfPublish\":\"2011\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Clean Architecture\",\"isbn\":\"34512\",\"yearOfPublish\":\"2017\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Test Driven Development by Example\",\"isbn\":\"45123\",\"yearOfPublish\":\"2003\",\"price\":\"50\",\"authorName\":\"Kent Beck\"},{\"title\":\"Working Effectively With Legacy Code\",\"isbn\":\"51234\",\"yearOfPublish\":\"2004\",\"price\":\"50\",\"authorName\":\"Michael C. Feathers\"}]";
    public static final String ISBN_FOR_CLEAN_CODE_BOOK = "12345";
    public static final String BOOK_PRICE_FOR_1_BOOK = "50";
    public static final String ISBN_NOT_FOUND_ERROR_JSON = "{\"message\":\"Requested ISBN not found/ISBN is null, Try again with valid ISBN \"}";
    public static final Integer NO_OF_UNIQUE_BOOKS = 5;

}
