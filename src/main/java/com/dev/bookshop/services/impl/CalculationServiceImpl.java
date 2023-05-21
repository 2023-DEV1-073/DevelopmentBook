package com.dev.bookshop.services.impl;

import com.dev.bookshop.services.CalculationService;
import com.dev.bookshop.services.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final Integer INDEX_OF_BEST_PRICE_INVOICE = 0;
    private static final Integer MINIMUM_BOOK_IN_A_GROUP = 1;

    @Override
    public Invoice getInvoice(ShoppingCart shoppingCart) {
        List<Invoice> invoices = processIntoPossibleInvoices(shoppingCart);
        return selectInvoiceWithBestPrice(invoices);
    }

    private List<Invoice> processIntoPossibleInvoices(ShoppingCart shoppingCart) {
        List<Invoice> possibleInvoices = new ArrayList<>();
        for (Integer maximumNumberOfBooksInAGroup = shoppingCart.getDifferentBooks().size();
             maximumNumberOfBooksInAGroup >= MINIMUM_BOOK_IN_A_GROUP; maximumNumberOfBooksInAGroup--) {
            possibleInvoices.add(groupByDifferentBooks(shoppingCart, maximumNumberOfBooksInAGroup));
        }
        return possibleInvoices;
    }

    private Invoice groupByDifferentBooks(ShoppingCart shoppingCart, Integer maximumNumberOfBooksInAGroup) {
        List<GroupOfDifferentBook> groupingOfDifferentBooks = new ArrayList<>();
        List<DifferentBook> clonedDifferentBooks = getClonedDifferentBooks(shoppingCart);
        while (!clonedDifferentBooks.isEmpty()) {
            maximumNumberOfBooksInAGroup = updateMaximumNumberOfBooksInAGroup(maximumNumberOfBooksInAGroup, clonedDifferentBooks.size());
            GroupOfDifferentBook differentBooks = createNextGroup(clonedDifferentBooks, maximumNumberOfBooksInAGroup);
            groupingOfDifferentBooks.add(differentBooks);
        }
        return new Invoice(groupingOfDifferentBooks);
    }

    private List<DifferentBook> getClonedDifferentBooks(ShoppingCart shoppingCart) {
        return shoppingCart.getDifferentBooks().stream()
                           .map(shoppingOrder -> new DifferentBook(shoppingOrder.getBook(), shoppingOrder.getQuantity()))
                           .collect(Collectors.toList());
    }

    private Integer updateMaximumNumberOfBooksInAGroup(Integer maximumNumberOfBooksInAGroup, Integer numberOfDifferentBooksToBeProcessed) {
        if (maximumNumberOfBooksInAGroup > numberOfDifferentBooksToBeProcessed) {
            return numberOfDifferentBooksToBeProcessed;
        }
        return maximumNumberOfBooksInAGroup;
    }

    private GroupOfDifferentBook createNextGroup(List<DifferentBook> remainingBooks, Integer maximumDifferentBooks) {
        HashSet<Book> books = new HashSet<>();
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

    private Invoice selectInvoiceWithBestPrice(List<Invoice> invoices) {
        invoices.sort(Comparator.comparing(Invoice::getDiscountedPrice));
        return invoices.get(INDEX_OF_BEST_PRICE_INVOICE);
    }

}
