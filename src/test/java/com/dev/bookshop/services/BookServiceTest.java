package com.dev.bookshop.services;

import com.dev.bookshop.services.model.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.dev.bookshop.constants.TestConstants.COLLECTION_OF_ISBN;
import static com.dev.bookshop.constants.TestConstants.NO_OF_UNIQUE_BOOKS;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void shouldGetAll5BookDetail() {
        List<Book> books = bookService.getAll();
        Assert.assertEquals(NO_OF_UNIQUE_BOOKS, Integer.valueOf(books.size()));
        books.forEach(book -> Assert.assertTrue(COLLECTION_OF_ISBN.contains(book.getIsbn())));
    }

}