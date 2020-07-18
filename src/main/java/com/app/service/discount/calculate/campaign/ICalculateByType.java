package com.app.service.discount.calculate.campaign;

import com.app.service.cart.ShoppingCart;

public interface ICalculateByType {
    void setShoppingCart(ShoppingCart cart);

    void calculate();
}
