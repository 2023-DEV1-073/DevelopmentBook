package com.dev.bookshop.mappers;

import com.dev.bookshop.controllers.model.BookDetail;
import com.dev.bookshop.services.model.Book;
import com.dev.bookshop.services.model.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

import static com.dev.bookshop.validators.ShoppingCartValidator.validateShoppingCart;


@Mapper(componentModel = "spring")
public interface ResponseMapper {
    List<BookDetail> toBookDetailResponse(List<Book> source);

    default ShoppingCart toShoppingCart(com.dev.bookshop.controllers.model.ShoppingCart source) {
        validateShoppingCart(source);
        List<Book> books = new ArrayList<>();
        for (String isbn : source.getIsbn()) {
            books.add(Book.findByISBN(isbn));
        }
        return new ShoppingCart(books);
    }

}
