package com.dev.bookshop.exception;

import com.dev.bookshop.controllers.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ISBNNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EmptyCartException.class, DuplicateISBNException.class, MandatoryDetailMissingException.class, MinimumQuantityException.class})
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
