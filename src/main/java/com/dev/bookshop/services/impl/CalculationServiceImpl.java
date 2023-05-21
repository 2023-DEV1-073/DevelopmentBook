package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.Price;
import com.dev.bookshop.services.model.ShoppingCart;
import org.springframework.stereotype.Service;


@Service
public class CalculationServiceImpl implements CalculationService {

    public static final int TWO_BOOKS = 2;
    public static final int THREE_BOOKS = 3;
    public static final int FOUR_BOOKS = 4;
    public static final Integer DISCOUNT_FIVE = 5;
    public static final Integer DISCOUNT_TEN = 10;
    public static final Integer DISCOUNT_TWENTY = 20;
    public static final Integer DISCOUNT_ZERO = 0;

    @Override
    public Price getPrice(ShoppingCart shoppingCart) {
        Double totalPrice = getTotalPrice(shoppingCart);
        if (shoppingCart.getDifferentBooks().size() == TWO_BOOKS) {
            Double discountedPrice = getDiscountedPrice(totalPrice, DISCOUNT_FIVE);
            return new Price(totalPrice, discountedPrice, DISCOUNT_FIVE);
        } else if (shoppingCart.getDifferentBooks().size() == THREE_BOOKS) {
            Double discountedPrice = getDiscountedPrice(totalPrice, DISCOUNT_TEN);
            return new Price(totalPrice, discountedPrice, DISCOUNT_TEN);
        } else if (shoppingCart.getDifferentBooks().size() == FOUR_BOOKS) {
            Double discountedPrice = getDiscountedPrice(totalPrice, DISCOUNT_TWENTY);
            return new Price(totalPrice, discountedPrice, DISCOUNT_TWENTY);
        } else {
            return new Price(totalPrice, totalPrice, DISCOUNT_ZERO);
        }
    }

    private Double getTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getDifferentBooks().stream().mapToDouble(s -> Double.parseDouble(s.getPrice())).sum();
    }

    private Double getDiscountedPrice(Double totalPrice, Integer discount) {
        return totalPrice * (1.0 - (discount / 100.0));
    }
}
