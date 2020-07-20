package com.app.entity.discount;

import com.app.entity.Category;
import com.app.domain.discount.type.DiscountType;

public class Campaign implements IDiscountStyle {
    private Category category;
    private double discount;
    private int minimumItem;
    private DiscountType discountType;

    public Campaign(
            Category category,
            double discount,
            int minimumItem,
            DiscountType discountType
    ) {
        this.setCategory(category);
        this.setDiscount(discount);
        this.setMinimumItem(minimumItem);
        this.setDiscountType(discountType);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getMinimumItem() {
        return minimumItem;
    }

    public void setMinimumItem(int minimumItem) {
        this.minimumItem = minimumItem;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
