package com.app.domain.discount.type;

import com.app.entity.discount.*;
import com.app.service.cart.ShoppingCart;

public class Amount implements CalculateByTypeInterface {
    private ShoppingCart shoppingCart;
    private DiscountStyleInterface discountStyle;

    public void setCampaign(Campaign campaign) {
        setDiscountStyle(campaign);
    }

    private void setDiscountStyle(DiscountStyleInterface discountStyle) {
        this.discountStyle = discountStyle;
    }

    public void setCoupon(Coupon coupon) {
        setDiscountStyle(coupon);
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double applyDiscount() {
        shoppingCart.setTotalDiscountAmount(shoppingCart.getTotalDiscountAmount() - discountStyle.getDiscount());

        return discountStyle.getDiscount();
    }
}
