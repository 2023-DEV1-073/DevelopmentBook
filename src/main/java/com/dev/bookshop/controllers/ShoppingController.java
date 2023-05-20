package com.dev.bookshop.controllers;

import com.dev.bookshop.controllers.model.BookDetail;
import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.mappers.ResponseMapper;
import com.dev.bookshop.services.BookService;
import com.dev.bookshop.services.CalculationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class ShoppingController {

    @Autowired
    BookService bookService;
    @Autowired
    CalculationService calculationService;
    ResponseMapper mapper = Mappers.getMapper(ResponseMapper.class);

    @ApiOperation(value = "Get All Books", notes = "Returns all available books")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BookDetail[].class)})
    @GetMapping(value = "books", produces = "application/json")
    public ResponseEntity<List<BookDetail>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(mapper.toBookDetailResponse(bookService.getAll()));
    }

    @ApiOperation(value = "get the calculated book price ", notes = "get the calculated book price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")})
    @PostMapping(value = "calculatePrice", produces = "application/json")
    public ResponseEntity<String> getCalculatedPrice(@RequestBody ShoppingCart shoppingCart) {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(calculationService.getPrice(shoppingCart.getIsbn()));
    }
}
