package com.dev.bookshop.validators;

import com.dev.bookshop.controllers.model.BookOrder;
import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.exception.DuplicateISBNException;
import com.dev.bookshop.exception.EmptyCartException;
import com.dev.bookshop.exception.MandatoryDetailMissingException;
import com.dev.bookshop.exception.MinimumQuantityException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.dev.bookshop.constants.ApplicationConstants.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShoppingCartValidator {

    public static void validateShoppingCart(ShoppingCart shoppingCart) {
        checkForEmptyCart(shoppingCart);
        checkMandatoryDetailsInBookOrder(shoppingCart);
        checkDuplicateItemsInCart(shoppingCart);
        checkMinimumQuantityInOrder(shoppingCart);
    }

    private static void checkForEmptyCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null || CollectionUtils.isEmpty(shoppingCart.getBookOrders())) {
            throw new EmptyCartException();
        }
    }

    private static void checkDuplicateItemsInCart(ShoppingCart shoppingCart) {
        String duplicateIsbns = getDuplicateIsbns(shoppingCart);
        if (StringUtils.isNotBlank(duplicateIsbns)) {
            throw new DuplicateISBNException(DUPLICATE_BOOK_ENTRY_ERROR.replace("{}", duplicateIsbns));
        }
    }

    private static String getDuplicateIsbns(ShoppingCart shoppingCart) {

        return shoppingCart.getBookOrders().stream()
                           .map(BookOrder::getIsbn)
                           .collect(Collectors.toList())
                           .stream()
                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                           .entrySet()
                           .stream()
                           .filter(m -> m.getValue() > 1).map(Map.Entry::getKey)
                           .collect(Collectors.joining(","));
    }

    private static void checkMandatoryDetailsInBookOrder(ShoppingCart shoppingCart) {
        for (BookOrder bookOrder : shoppingCart.getBookOrders()) {
            if (StringUtils.isBlank(bookOrder.getIsbn())) {
                throw new MandatoryDetailMissingException(ISBN_DETAIL_MISSING_ERROR);
            }
            if (bookOrder.getQuantity() == null) {
                throw new MandatoryDetailMissingException(QUANTITY_DETAIL_MISSING_ERROR);
            }
        }
    }

    private static void checkMinimumQuantityInOrder(ShoppingCart shoppingCart) {
        for (BookOrder bookOrder : shoppingCart.getBookOrders()) {
            if (bookOrder.getQuantity() <= 0) {
                throw new MinimumQuantityException();
            }
        }
    }

}
