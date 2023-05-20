package com.dev.bookshop.services;

import com.dev.bookshop.services.model.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void shouldGetAll5BookDetail() {
        List<String> collectionOfISBN = Arrays.asList("12345", "23451", "34512", "45123", "51234");
        List<Book> books = bookService.getAll();
        Assert.assertEquals(5, books.size());
        books.forEach(book -> Assert.assertTrue(collectionOfISBN.contains(book.getIsbn())));
    }

}