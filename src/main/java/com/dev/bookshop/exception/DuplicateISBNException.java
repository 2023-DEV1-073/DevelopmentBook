package com.dev.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateISBNException extends RuntimeException {

    public DuplicateISBNException(String message) {
        super(message);
    }
}
