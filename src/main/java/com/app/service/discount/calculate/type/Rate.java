package com.app.service.discount.calculate.type;

import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.entity.discount.IDiscountStyle;
import com.app.service.cart.ShoppingCart;

public class Rate implements ICalculateByType {
    private IDiscountStyle discountStyle;
    private ShoppingCart shoppingCart;

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
        double netDiscountAsAmount = shoppingCart.getTotalPrice() * (discountStyle.getDiscount() / 100);
        shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - netDiscountAsAmount);
    }
}
