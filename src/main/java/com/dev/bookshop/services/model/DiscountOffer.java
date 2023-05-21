package com.dev.bookshop.services.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum DiscountOffer {

    DEFAULT(1, 0),
    TWO(2, 5),
    THREE(3, 10),
    FOUR(4, 20),
    FIVE(5, 25);
    final Integer numberOfDifferentBooks;
    final Integer discount;

    public static Integer findDiscountByNumberOfDifferentBooks(Integer numberOfDifferentBooks) {
        return Arrays.stream(DiscountOffer.values())
                     .filter(p -> Objects.equals(p.getNumberOfDifferentBooks(), numberOfDifferentBooks))
                     .findAny()
                     .orElse(DEFAULT).getDiscount();
    }
}
