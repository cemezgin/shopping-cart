package com.app.entity;

import com.app.service.discount.calculate.DiscountType;

public class Coupon {
    private int minimumAmount;
    private float discount;
    private DiscountType discountType;

    public Coupon(
            int minimumAmount,
            float discount,
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
