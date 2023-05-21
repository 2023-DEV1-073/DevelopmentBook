package com.dev.bookshop.services.model;


import lombok.Getter;

import java.util.Set;

@Getter
public class GroupOfDifferentBook {

    private final Set<Book> books;
    private final Integer discountApplied;
    private final Double totalPrice;
    private final Double discountedPrice;

    public GroupOfDifferentBook(Set<Book> books) {
        this.books = books;
        this.discountApplied = calculateDiscountApplied();
        this.totalPrice = calculateTotalPrice();
        this.discountedPrice = calculateDiscountedPrice();
    }

    private Integer calculateDiscountApplied() {
        return DiscountOffer.findDiscountByNumberOfDifferentBooks(books.size());
    }

    private Double calculateTotalPrice() {
        return books.stream().mapToDouble(s -> Double.parseDouble(s.getPrice())).sum();
    }

    private Double calculateDiscountedPrice() {
        return totalPrice * (1.0 - (discountApplied / 100.0));
    }

}