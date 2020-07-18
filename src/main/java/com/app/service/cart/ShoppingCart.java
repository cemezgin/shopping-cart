package com.app.service.cart;

import com.app.entity.*;
import com.app.entity.discount.*;
import com.app.service.discount.calculate.Discount;
import com.app.service.discount.calculate.calculator.*;

import java.util.*;

public class ShoppingCart implements IShoppingCart {
    private final Set<CartItem> shoppingCart = new HashSet<>();
    private List<Campaign> campaignSet = new ArrayList<>();
    private double totalPrice = 0.0;
    private double totalAmountAfterDiscounts = 0.0;
    private double totalCouponDiscount = 0.0;
    private double totalCampaignDiscount = 0.0;
    private double deliveryCost = 0.0;

    public void setTotalAmountAfterDiscounts(double totalPrice) {
        this.totalAmountAfterDiscounts = totalPrice;
    }

    public double getTotalAmountAfterDiscounts()
    {
        return totalAmountAfterDiscounts;
    }

    public void setTotalCouponDiscount(double totalCouponDiscount)
    {
        this.totalCouponDiscount = totalCouponDiscount;
    }

    public double getTotalCouponDiscount() {
        return totalCouponDiscount;
    }

    public void setTotalCampaignDiscount(double totalCampaignDiscount) {
        this.totalCampaignDiscount = totalCampaignDiscount;
    }

    public double getTotalCampaignDiscount() {
        return totalCampaignDiscount;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        this.shoppingCart.add(item);
    }

    public double getTotalPrice() {
        totalPrice += this.shoppingCart.stream().mapToDouble(
                cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity()
        ).sum();

        return totalPrice;
    }

    public Set<CartItem> getShoppingCart() {
        return this.shoppingCart;
    }

    public void applyDiscounts(Campaign... campaigns) {
        this.campaignSet.addAll(Arrays.asList(campaigns));
        Discount discount = new Discount();
        campaignSet.forEach(campaign -> {
            Calculator calculator = new Calculator(new CampaignCalculator(this, campaign));
            calculator.calculate();
        });
    }

    public void applyCoupon(Coupon coupon) {
        Calculator calculator = new Calculator(new CouponCalculator(this, coupon));
        calculator.calculate();
    }
}
