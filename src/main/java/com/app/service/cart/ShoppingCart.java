package com.app.service.cart;

import com.app.entity.*;
import com.app.service.discount.calculate.Discount;
import com.app.service.discount.calculate.campaign.Calculate;

import java.util.*;

public class ShoppingCart implements IShoppingCart {
    private final Set<CartItem> shoppingCart = new HashSet<>();
    private List<Campaign> campaignSet = new ArrayList<>();
    private double totalPrice = 0.0;
    public void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        this.shoppingCart.add(item);
    }

    public double getTotalPrice()
    {
        totalPrice += this.shoppingCart.stream().mapToDouble(
                cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity()
        ).sum();

        return totalPrice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Set<CartItem> getShoppingCart() {
        return this.shoppingCart;
    }

    public void applyDiscounts(Campaign... campaigns) {
        this.campaignSet.addAll(Arrays.asList(campaigns));
        Discount discount = new Discount();
        campaignSet.forEach(campaign -> {
            Calculate calculate = new Calculate(discount.selectCampaignType(campaign));
            calculate.setShoppingCart(this);
        });
    }

    public void applyCoupon(Coupon coupon) {

    }
}
