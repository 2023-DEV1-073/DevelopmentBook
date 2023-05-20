package com.dev.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.dev.bookshop.constants.ApplicationConstants.ISBN_NOT_FOUND_ERROR;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ISBNNotFoundException extends RuntimeException {

    public ISBNNotFoundException() {
        super(ISBN_NOT_FOUND_ERROR);
    }

}
