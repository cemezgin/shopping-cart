package com.app.service.discount.calculate.calculator;

import com.app.entity.CartItem;
import com.app.entity.discount.Campaign;
import com.app.service.cart.ShoppingCart;
import com.app.service.discount.calculate.Discount;
import com.app.service.discount.calculate.type.Calculate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CampaignCalculator implements ICalculator {
    private final ShoppingCart shoppingCart;
    private final Campaign campaign;

    public CampaignCalculator(ShoppingCart shoppingCart, Campaign campaign) {
        this.shoppingCart = shoppingCart;
        this.campaign = campaign;
    }

    public void calculate() {
        HashMap<Campaign, Set<CartItem>> quantityByCampaign = new HashMap<>();
        final int[] totalCategoryQuantity = {0};

        this.shoppingCart.getShoppingCart().forEach(cartItem -> {

            if (!quantityByCampaign.containsKey(campaign)) {
                quantityByCampaign.put(campaign, new HashSet<>());
            }
            if (campaign.getCategory().equals(cartItem.getProduct().getCategory()) ||
                    campaign.getCategory().equals(cartItem.getProduct().getCategory().getParentCategory())) {
                quantityByCampaign.get(campaign).add(cartItem);
            }
        });

        quantityByCampaign.forEach((campaign, cartItemSet) -> {
            cartItemSet.forEach(cartItem -> {
                totalCategoryQuantity[0] = totalCategoryQuantity[0] + cartItem.getQuantity();
            });

            if (totalCategoryQuantity[0] > campaign.getMinimumItem()) {
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
