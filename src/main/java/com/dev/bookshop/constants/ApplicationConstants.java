package com.dev.bookshop.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApplicationConstants {

    public static final String ISBN_NOT_FOUND_ERROR = "Requested ISBN not found/ISBN is null, Try again with valid ISBN ";
    public static final String EMPTY_CART_ERROR = "Cart is Empty, add items and request again";
    public static final String DUPLICATE_BOOK_ENTRY_ERROR = "There are duplicate ISBN {}, Remove it and request again";
}
