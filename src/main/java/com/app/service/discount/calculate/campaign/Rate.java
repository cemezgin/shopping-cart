package com.app.service.discount.calculate.campaign;

import com.app.entity.Campaign;
import com.app.service.cart.ShoppingCart;

public class Rate implements ICalculateByType {
    private final Campaign campaign;
    private ShoppingCart shoppingCart;

    public Rate(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void calculate() {
        shoppingCart.getShoppingCart().forEach(cartItem -> {
            int count = 0;
            String title = cartItem.getProduct().getCategory().getTitle();
            if (campaign.getCategory().getTitle().equals(title) ||
                    campaign.getCategory().getParentCategory().getTitle().equals(title)) {
                count++;
            }
            if (campaign.getMinimumItem() > count) {
                applyDiscount();
            }
        });
    }

    private void applyDiscount() {
        double netDiscountAsAmount = shoppingCart.getTotalPrice() * (campaign.getDiscount() / 100);
        shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - netDiscountAsAmount);
    }
}
