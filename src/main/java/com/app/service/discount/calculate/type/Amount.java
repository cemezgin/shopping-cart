package com.app.service.discount.calculate.type;

import com.app.entity.discount.*;
import com.app.service.cart.ShoppingCart;

public class Amount implements ICalculateByType {
    private ShoppingCart shoppingCart;
    private IDiscountStyle discountStyle;

    public void setCampaign(Campaign campaign) {
        setDiscountStyle(campaign);
    }

    private void setDiscountStyle(IDiscountStyle discountStyle) {
        this.discountStyle = discountStyle;
    }

    public void setCoupon(Coupon coupon) {
        setDiscountStyle(coupon);
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void applyDiscount() {
        shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - discountStyle.getDiscount());
    }
}
