package com.app.entity;

import com.app.service.discount.calculate.campaign.DiscountType;

public class Coupon {
    private int minimumAmount;
    private double discount;
    private DiscountType discountType;

    public Coupon(
            int minimumAmount,
            double discount,
            DiscountType discountType
    ) {
        this.setDiscount(discount);
        this.setMinimumAmount(minimumAmount);
        this.setDiscountType(discountType);
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
