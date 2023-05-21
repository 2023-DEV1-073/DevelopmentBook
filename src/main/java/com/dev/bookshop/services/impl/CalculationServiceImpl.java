package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.DiscountOffer;
import com.dev.bookshop.services.model.Price;
import com.dev.bookshop.services.model.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public Price getPrice(ShoppingCart shoppingCart) {
        Double totalPrice = getTotalPrice(shoppingCart);
        Integer discount = DiscountOffer.findDiscountByNumberOfDifferentBooks(shoppingCart.getDifferentBooks().size());
        Double discountedPrice = getDiscountedPrice(totalPrice, discount);
        return new Price(totalPrice, discountedPrice, discount);
    }

    private Double getTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getDifferentBooks().stream().mapToDouble(s -> Double.parseDouble(s.getBook().getPrice()))
                           .sum();
    }

    private Double getDiscountedPrice(Double totalPrice, Integer discount) {
        return totalPrice * (1.0 - (discount / 100.0));
    }
}
