package com.dev.bookshop.validators;

import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.exception.DuplicateISBNException;
import com.dev.bookshop.exception.EmptyCartException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.dev.bookshop.constants.ApplicationConstants.DUPLICATE_BOOK_ENTRY_ERROR;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShoppingCartValidator {

    public static void checkForEmptyCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null || CollectionUtils.isEmpty(shoppingCart.getIsbn())) {
            throw new EmptyCartException();
        }
    }

    public static void checkDuplicateItemsInCart(ShoppingCart shoppingCart) throws DuplicateISBNException {
        String duplicateIsbns = getDuplicateIsbns(shoppingCart);
        if (StringUtils.isNotBlank(duplicateIsbns)) {
            throw new DuplicateISBNException(DUPLICATE_BOOK_ENTRY_ERROR.replace("{}", duplicateIsbns));
        }
    }

    private static String getDuplicateIsbns(ShoppingCart shoppingCart) {
        return shoppingCart.getIsbn().stream()
                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                           .entrySet()
                           .stream()
                           .filter(m -> m.getValue() > 1).map(Map.Entry::getKey)
                           .collect(Collectors.joining(","));
    }

}
