package com.mart.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CartTest {

    Cart cart = new Cart();
    int quantity = 2;

    @Test
    void testAddingProductToCart() {
        // Given
        Product iPadPro = new Product("test");

        int sizeOfCartBefore = cart.size();

        // when
        cart.addProduct(new CartItem(iPadPro, quantity));

        // then
        Assertions.assertEquals(quantity, cart.quantityInCart(iPadPro));
    }

    @Test
    void testQuantityInCartForPdtInCart() {
        // Given
        Product iPadPro = new Product("test");
        cart.addProduct(new CartItem(iPadPro, quantity));
        Assertions.assertEquals(quantity, cart.quantityInCart(iPadPro));
    }

    @Test
    void testNotInCartForPdtInCart() {
        // Given
        Product iPadPro = new Product("test");
        Assertions.assertEquals(0, cart.quantityInCart(iPadPro));
    }

    @Test
    void testRemoveAProductFromCart() {
        // Given
        String productName = "test";
        Product iPadPro = new Product(productName);
        CartItem cartItem = new CartItem(iPadPro, quantity);
        cart.addProduct(cartItem);

        // when
        cart.removeProduct(productName);

        // then
        Assertions.assertEquals(0, cart.size());
        Assertions.assertEquals(0, cart.quantityInCart(iPadPro));
        Assertions.assertEquals(List.of(productName), cart.getRemovedProductNames());
    }



}