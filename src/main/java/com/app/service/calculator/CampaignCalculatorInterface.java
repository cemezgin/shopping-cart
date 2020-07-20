package com.app.service.calculator;

import com.app.entity.CartItem;
import com.app.entity.discount.Campaign;
import com.app.service.cart.ShoppingCart;
import com.app.domain.discount.Discount;
import com.app.domain.discount.type.Calculate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CampaignCalculatorInterface implements CalculatorInterface {
    private final ShoppingCart shoppingCart;
    private final Campaign campaign;

    public CampaignCalculatorInterface(ShoppingCart shoppingCart, Campaign campaign) {
        this.shoppingCart = shoppingCart;
        this.campaign = campaign;
    }

    private HashMap<Campaign, Set<CartItem>> mapCampaignAndCartItem() {
        HashMap<Campaign, Set<CartItem>> quantityByCampaign = new HashMap<>();

        this.shoppingCart.getShoppingCart().forEach(cartItem -> {

            if (!quantityByCampaign.containsKey(campaign)) {
                quantityByCampaign.put(campaign, new HashSet<>());
            }
            if (campaign.getCategory().equals(cartItem.getProduct().getCategory()) ||
                    campaign.getCategory().equals(cartItem.getProduct().getCategory().getParentCategory())) {
                quantityByCampaign.get(campaign).add(cartItem);
            }
        });

        return quantityByCampaign;
    }

    public void calculate() {
        final int[] totalCategoryQuantity = {0};

        mapCampaignAndCartItem().forEach((campaign, cartItemSet) -> {
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
