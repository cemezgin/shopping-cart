package com.app.service.discount.calculate.type;

import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;

public interface ICalculateByType {
    void setShoppingCart(ShoppingCart cart);

    void setCampaign(Campaign campaign);

    void setCoupon(Coupon coupon);

    double applyDiscount();
}
