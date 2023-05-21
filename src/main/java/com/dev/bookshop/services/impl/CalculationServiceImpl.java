package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public Invoice getInvoice(ShoppingCart shoppingCart) {
        return new Invoice(groupByDifferentBooks(shoppingCart));
    }

    private List<GroupOfDifferentBook> groupByDifferentBooks(ShoppingCart shoppingCart) {
        List<GroupOfDifferentBook> groupingOfDifferentBooks = new ArrayList<>();
        List<DifferentBook> clonedDifferentBooks = getClonedDifferentBooks(shoppingCart);
        while (!clonedDifferentBooks.isEmpty()) {
            GroupOfDifferentBook differentBooks = createNextGroup(clonedDifferentBooks);
            groupingOfDifferentBooks.add(differentBooks);
        }
        return groupingOfDifferentBooks;
    }

    private List<DifferentBook> getClonedDifferentBooks(ShoppingCart shoppingCart) {
        return shoppingCart.getDifferentBooks().stream()
                           .map(shoppingOrder -> new DifferentBook(shoppingOrder.getBook(), shoppingOrder.getQuantity()))
                           .collect(Collectors.toList());
    }

    private GroupOfDifferentBook createNextGroup(List<DifferentBook> remainingBooks) {
        HashSet<Book> books = new HashSet<>();
        Integer maximumDifferentBooks = remainingBooks.size();
        for (DifferentBook differentBook : new ArrayList<>(remainingBooks)) {
            books.add(differentBook.getBook());
            updateRemainingBooks(remainingBooks, differentBook);
            if (isMaximumDifferentBooksGrouped(books, maximumDifferentBooks)) {
                return new GroupOfDifferentBook(books);
            }
        }
        return new GroupOfDifferentBook(books);
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

}
