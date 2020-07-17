package com.app.service.cart;

import com.app.entity.CartItem;
import com.app.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
    private final Set<CartItem> shoppingCart = new HashSet<CartItem>();

    public void addItem(Product product, int quantity)
    {
        CartItem item = new CartItem(product, quantity);
        this.shoppingCart.add(item);
    }

    public Set<CartItem> getShoppingCart()
    {
        return this.shoppingCart;
    }
}
