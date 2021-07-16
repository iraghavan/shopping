package com.mart;

import com.mart.domain.Cart;
import com.mart.domain.CartItem;
import com.mart.domain.Product;

public class Shop {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product iPadPro = new Product("iPad pro");
        Product heroInkPen = new Product("Hero ink pen");
        Product cricketBat = new Product("GM Cricket Bat");
        cart.addProduct(new CartItem(iPadPro, 1));
        cart.addProduct(new CartItem(heroInkPen, 1));
        cart.addProduct(new CartItem(cricketBat,2 ));
    }
}
