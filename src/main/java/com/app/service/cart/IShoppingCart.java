package com.app.service.cart;

import com.app.entity.Campaign;
import com.app.entity.Coupon;
import com.app.entity.Product;

public interface IShoppingCart {
    void addItem(Product product, int quantity);

    void applyDiscounts(Campaign... campaigns);

    void applyCoupon(Coupon coupon);
}
