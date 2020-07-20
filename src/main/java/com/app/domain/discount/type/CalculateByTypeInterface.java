package com.app.domain.discount.type;

import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;

public interface CalculateByTypeInterface {
    void setShoppingCart(ShoppingCart cart);

    void setCampaign(Campaign campaign);

    void setCoupon(Coupon coupon);

    double applyDiscount();
}
