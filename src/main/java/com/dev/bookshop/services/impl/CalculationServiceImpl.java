package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.Book;
import org.springframework.stereotype.Service;


@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public String getPrice(String isbn) {
        return Book.findByISBN(isbn).getPrice();
    }
}
