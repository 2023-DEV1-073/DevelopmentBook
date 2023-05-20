package com.dev.bookshop.services;


import com.dev.bookshop.services.model.Price;
import com.dev.bookshop.services.model.ShoppingCart;

public interface CalculationService {

    Price getPrice(ShoppingCart shoppingCart);

}
