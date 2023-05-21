package com.dev.bookshop.services.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Invoice {

    List<GroupOfDifferentBook> groupOfDifferentBooks;
    Double totalPrice;
    Double discountedPrice;

    public Invoice(List<GroupOfDifferentBook> groupOfDifferentBooks) {
        this.groupOfDifferentBooks = groupOfDifferentBooks;
        this.totalPrice = calculateTotalPrice();
        this.discountedPrice = calculateDiscountedPrice();
    }

    private Double calculateTotalPrice() {
        return groupOfDifferentBooks.stream().mapToDouble(GroupOfDifferentBook::getTotalPrice).sum();
    }

    private Double calculateDiscountedPrice() {
        return groupOfDifferentBooks.stream().mapToDouble(GroupOfDifferentBook::getDiscountedPrice).sum();
    }
}
