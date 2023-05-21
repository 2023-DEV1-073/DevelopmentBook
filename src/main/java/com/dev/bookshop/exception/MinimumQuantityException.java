package com.dev.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.dev.bookshop.constants.ApplicationConstants.MINIMUM_BOOK_QUANTITY_ERROR;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinimumQuantityException extends RuntimeException {

    public MinimumQuantityException() {
        super(MINIMUM_BOOK_QUANTITY_ERROR);
    }
}
