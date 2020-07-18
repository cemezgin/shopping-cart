package com.app;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import com.app.service.discount.calculate.type.DiscountType;

public class Main {
    public static void main() {
        Category food = new Category("Food");
        Category electronic = new Category("Electronic");
        Category phones = new Category("Phones", electronic);

        Product apple = new Product("Apple", 100.0, food);
        Product almond = new Product("Almond", 150.0, food);
        Product huawei = new Product("Huawei", 1000.99, phones);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 5);
        cart.addItem(almond, 4);
        cart.addItem(huawei,8);

        Coupon coupon = new Coupon(300, 10, DiscountType.Rate);

        Campaign campaign1 = new Campaign(food,20,8,DiscountType.Amount);
        Campaign campaign2 = new Campaign(electronic,15,3,DiscountType.Rate);
        Campaign campaign3 = new Campaign(phones,100,2,DiscountType.Amount);

        cart.applyDiscounts(campaign1,campaign2,campaign3);
        cart.applyCoupon(coupon);

        cart.print();
    }
}
