package com.dev.bookshop.services.impl;

import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.Book;
import com.dev.bookshop.services.model.Price;
import org.springframework.stereotype.Service;


@Service
public class CalculationServiceImpl implements CalculationService {

    public static final int TWO_BOOKS = 2;
    public static final Integer DISCOUNT_FIVE = 5;
    public static final Integer DISCOUNT_ZERO = 0;

    @Override
    public Price getPrice(ShoppingCart shoppingCart) {
        Double totalPrice = getTotalPrice(shoppingCart);
        if (shoppingCart.getIsbn().size() == TWO_BOOKS) {
            Double discountedPrice = getDiscountedPrice(totalPrice, DISCOUNT_FIVE);
            return new Price(totalPrice, discountedPrice, DISCOUNT_FIVE);
        } else {
            return new Price(totalPrice, totalPrice, DISCOUNT_ZERO);
        }
    }

    private Double getTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getIsbn().stream().mapToDouble(s -> Double.parseDouble(Book.findByISBN(s).getPrice()))
                           .sum();
    }

    private Double getDiscountedPrice(Double totalPrice, Integer discount) {
        return totalPrice * (1.0 - (discount / 100.0));
    }
}
