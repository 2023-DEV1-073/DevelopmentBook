package com.dev.bookshop.mappers;

import com.dev.bookshop.controllers.model.BookDetail;
import com.dev.bookshop.controllers.model.BookOrder;
import com.dev.bookshop.controllers.model.Invoice;
import com.dev.bookshop.services.model.Book;
import com.dev.bookshop.services.model.DifferentBook;
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
        List<DifferentBook> books = new ArrayList<>();
        for (BookOrder bookOrder : source.getBookOrders()) {
            books.add(new DifferentBook(Book.findByISBN(bookOrder.getIsbn()), bookOrder.getQuantity()));
        }
        return new ShoppingCart(books);
    }

    Invoice toInvoice(com.dev.bookshop.services.model.Invoice source);

}
