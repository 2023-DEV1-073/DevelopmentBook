package com.dev.bookshop.mappers;

import com.dev.bookshop.controllers.model.BookDetail;
import com.dev.bookshop.services.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    List<BookDetail> toBookDetailResponse(List<Book> source);

}
