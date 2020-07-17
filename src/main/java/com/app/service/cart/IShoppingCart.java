package com.app.service.cart;

import com.app.entity.Product;

public interface IShoppingCart {
    void addItem(Product product, int quantity);
}
