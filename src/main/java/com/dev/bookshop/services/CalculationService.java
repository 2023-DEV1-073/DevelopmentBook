package com.dev.bookshop.services;


import com.dev.bookshop.services.model.Invoice;
import com.dev.bookshop.services.model.ShoppingCart;

public interface CalculationService {

    Invoice getInvoice(ShoppingCart shoppingCart);

}
