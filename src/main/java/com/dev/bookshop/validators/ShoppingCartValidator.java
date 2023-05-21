package com.dev.bookshop.validators;

import com.dev.bookshop.controllers.model.ShoppingCart;
import com.dev.bookshop.exception.EmptyCartException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShoppingCartValidator {

    public static void checkForEmptyCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null || CollectionUtils.isEmpty(shoppingCart.getIsbn())) {
            throw new EmptyCartException();
        }
    }

}
