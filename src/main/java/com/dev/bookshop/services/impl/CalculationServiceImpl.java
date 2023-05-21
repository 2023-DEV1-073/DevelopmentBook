package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public Price getPrice(ShoppingCart shoppingCart) {
        Double totalPrice = 0.0;
        Double discountedPrice = 0.0;
        Integer discount = DiscountOffer.findDiscountByNumberOfDifferentBooks(shoppingCart.getDifferentBooks().size());
        List<Set<Book>> groupingOfDifferentBooks = groupByDifferentBooks(shoppingCart);
        return getCalulatedPrice(totalPrice, discountedPrice, discount, groupingOfDifferentBooks);
    }

    private List<Set<Book>> groupByDifferentBooks(ShoppingCart shoppingCart) {
        List<Set<Book>> groupingOfDifferentBooks = new ArrayList<>();
        List<DifferentBook> clonedDifferentBooks = getClonedDifferentBooks(shoppingCart);
        while (!clonedDifferentBooks.isEmpty()) {
            Set<Book> differentBooks = createNextGroup(clonedDifferentBooks);
            groupingOfDifferentBooks.add(differentBooks);
        }
        return groupingOfDifferentBooks;
    }

    private List<DifferentBook> getClonedDifferentBooks(ShoppingCart shoppingCart) {
        return shoppingCart.getDifferentBooks().stream()
                           .map(shoppingOrder -> new DifferentBook(shoppingOrder.getBook(), shoppingOrder.getQuantity()))
                           .collect(Collectors.toList());
    }

    private Set<Book> createNextGroup(List<DifferentBook> remainingBooks) {
        HashSet<Book> books = new HashSet<>();
        Integer maximumDifferentBooks = remainingBooks.size();
        for (DifferentBook differentBook : new ArrayList<>(remainingBooks)) {
            books.add(differentBook.getBook());
            updateRemainingBooks(remainingBooks, differentBook);
            if (isMaximumDifferentBooksGrouped(books, maximumDifferentBooks)) {
                break;
            }
        }
        return books;
    }

    private void updateRemainingBooks(List<DifferentBook> remainingBooks, DifferentBook differentBook) {
        if (isLastCopyInOrder(differentBook)) {
            remainingBooks.remove(differentBook);
        } else {
            reduceByOne(differentBook);
        }
    }

    private boolean isLastCopyInOrder(DifferentBook processedBook) {
        return processedBook.getQuantity() == 1;
    }

    private void reduceByOne(DifferentBook processedBook) {
        processedBook.setQuantity(processedBook.getQuantity() - 1);
    }

    private boolean isMaximumDifferentBooksGrouped(HashSet<Book> books, Integer maxSetSize) {
        return books.size() == maxSetSize;
    }

    private Price getCalulatedPrice(Double totalPrice, Double discountedPrice, Integer discount, List<Set<Book>> groupingOfDifferentBooks) {
        for (Set<Book> bookSet : groupingOfDifferentBooks) {
            Double totalPriceOfSet = getTotalPrice(bookSet);
            totalPrice += totalPriceOfSet;
            discountedPrice += getDiscountedPrice(totalPriceOfSet, DiscountOffer.findDiscountByNumberOfDifferentBooks(bookSet.size()));
        }
        return new Price(totalPrice, discountedPrice, discount);
    }

    private Double getTotalPrice(Set<Book> bookSet) {
        return bookSet.stream().mapToDouble(s -> Double.parseDouble(s.getPrice())).sum();
    }

    private Double getDiscountedPrice(Double totalPrice, Integer discount) {
        return totalPrice * (1.0 - (discount / 100.0));
    }
}
