package com.dev.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.dev.bookshop.constants.ApplicationConstants.EMPTY_CART_ERROR;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyCartException extends RuntimeException {
    public EmptyCartException() {
        super(EMPTY_CART_ERROR);
    }
}
