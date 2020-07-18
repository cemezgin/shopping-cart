package com.app.service.cart;

import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.entity.Product;

public interface IShoppingCart {
    void addItem(Product product, int quantity);

    void applyDiscounts(Campaign... campaigns);

    void applyCoupon(Coupon coupon);
}
