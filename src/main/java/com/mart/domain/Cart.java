package com.mart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();
    private List<CartItem> removedCartItems = new ArrayList<>();

    public void addProduct(CartItem cartItem) {
        System.out.println("Adding product " + cartItem.getProductName() + "  to cart.");
        cartItems.add(cartItem);
    }

    public void removeProduct(String productName) {
        List<CartItem> itemsToRemove = cartItems.stream()
            .filter((c) -> c.getProductName().equals(productName))
            .collect(Collectors.toList());
        cartItems.removeAll(itemsToRemove);
        this.removedCartItems.addAll(itemsToRemove);
    }

    public List<String> getRemovedProductNames() {
        return removedCartItems.stream()
            .map((c) -> c.getProductName())
            .collect(Collectors.toList());
    }

    public int size() {
        return this.cartItems.size();
    }

    public int quantityInCart(Product product) {
        return cartItems.stream()
            .filter((c) -> c.getProductName().equals(product.getName()))
            .map((c) -> c.getQuantity())
            .collect(Collectors.summingInt(Integer::intValue));
    }

}
