package com.dev.bookshop.controllers.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCart {
    private List<BookOrder> bookOrders;
}
