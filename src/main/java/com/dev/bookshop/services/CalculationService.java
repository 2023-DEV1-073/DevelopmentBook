package com.dev.bookshop.services;


import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.services.model.Price;

public interface CalculationService {

    Price getPrice(ShoppingCart shoppingCart);

}
