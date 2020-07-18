package com.app.service.delivery;

import com.app.service.cart.ShoppingCart;

public interface IDeliveryCostCalculator {
    double calculateFor(ShoppingCart cart);
}
