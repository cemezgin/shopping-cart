package com.app;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import com.app.service.delivery.DeliveryCostCalculator;
import com.app.domain.discount.type.DiscountType;

public class Main {
    public static void main(String[] args) {
        Category food = new Category("Food");
        Category electronic = new Category("Electronic");
        Category phones = new Category("Phones", electronic);

        Product apple = new Product("Apple", 100.0, food);
        Product almond = new Product("Almond", 150.0, food);
        Product huawei = new Product("Huawei", 1000.0, phones);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(almond, 4);
        cart.addItem(huawei, 8);

        DeliveryCostCalculator deliveryCostCalculator =
                new DeliveryCostCalculator(1, 1, DeliveryCostCalculator.FIXED_COST);
        deliveryCostCalculator.calculateFor(cart);

        Coupon coupon = new Coupon(4, 10, DiscountType.Rate);

        Campaign campaign1 = new Campaign(food, 20, 8, DiscountType.Amount);
        Campaign campaign2 = new Campaign(food, 10, 3, DiscountType.Rate);
        Campaign campaign3 = new Campaign(electronic, 100, 2, DiscountType.Amount);

        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        cart.print();
    }
}
