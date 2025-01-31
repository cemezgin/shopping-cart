package com.app.domain.discount.type;


import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;

public class Calculate {
    private final CalculateByTypeInterface typeStrategy;

    public Calculate(CalculateByTypeInterface typeStrategy) {
        this.typeStrategy = typeStrategy;
    }

    public void setShoppingCart(ShoppingCart cart) {
        typeStrategy.setShoppingCart(cart);
    }

    public void setCampaign(Campaign campaign) {
        typeStrategy.setCampaign(campaign);
    }

    public void setCoupon(Coupon coupon) {
        typeStrategy.setCoupon(coupon);
    }

    public double applyDiscount() {
        return typeStrategy.applyDiscount();
    }
}
