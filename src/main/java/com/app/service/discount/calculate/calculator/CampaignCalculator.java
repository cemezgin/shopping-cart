package com.app.service.discount.calculate.calculator;

import com.app.entity.discount.Campaign;
import com.app.service.cart.ShoppingCart;
import com.app.service.discount.calculate.Discount;
import com.app.service.discount.calculate.type.Calculate;

public class CampaignCalculator implements ICalculator {
    private final ShoppingCart shoppingCart;
    private final Campaign campaign;

    public CampaignCalculator(ShoppingCart shoppingCart, Campaign campaign) {
        this.shoppingCart = shoppingCart;
        this.campaign = campaign;
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
                apply();
            }
        });
    }

    private void apply() {
        Discount discount = new Discount();
        Calculate calculate = new Calculate(discount.setDiscountType(campaign.getDiscountType()));
        calculate.setCampaign(campaign);
        calculate.setShoppingCart(shoppingCart);
        double finalDiscountAmount = calculate.applyDiscount();
        shoppingCart.setTotalCampaignDiscount(shoppingCart.getTotalCampaignDiscount() + finalDiscountAmount);
    }
}
