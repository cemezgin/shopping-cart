package com.app.domain.discount.type;

import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.entity.discount.DiscountStyleInterface;
import com.app.service.cart.ShoppingCart;

public class Rate implements CalculateByTypeInterface {
    private DiscountStyleInterface discountStyle;
    private ShoppingCart shoppingCart;

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
        double netDiscountAsAmount = shoppingCart.getTotalPrice() * (discountStyle.getDiscount() / 100);
        shoppingCart.setTotalDiscountAmount(shoppingCart.getTotalDiscountAmount() - netDiscountAsAmount);

        return netDiscountAsAmount;
    }
}
