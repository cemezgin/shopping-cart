package com.app.entity;

import com.app.service.discount.calculate.DiscountType;

public class Campaign {
    private Category category;
    private float discount;
    private int minimumAmount;
    private DiscountType discountType;

    public Campaign(
            Category category,
            float discount,
            int minimumAmount,
            DiscountType discountType
    ) {
        this.setCategory(category);
        this.setDiscount(discount);
        this.setMinimumAmount(minimumAmount);
        this.setDiscountType(discountType);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
