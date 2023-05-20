package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.BookService;
import com.dev.bookshop.services.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getAll() {
        return Arrays.asList(Book.values());
    }
}
