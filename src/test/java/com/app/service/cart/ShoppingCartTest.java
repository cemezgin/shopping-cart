package com.app.service.cart;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.delivery.DeliveryCostCalculator;
import com.app.domain.discount.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    Category food = new Category("Food");
    Category electronic = new Category("Electronic");
    Category phones = new Category("Phones", electronic);

    Product apple = new Product("Apple", 100.0, food);
    Product almond = new Product("Almond", 150.0, food);
    Product huawei = new Product("Huawei", 1000.0, phones);

    DeliveryCostCalculator deliveryCostCalculator =
            new DeliveryCostCalculator(1, 1, DeliveryCostCalculator.FIXED_COST);

    Coupon coupon = new Coupon(4, 10, DiscountType.Rate);

    Campaign campaign1 = new Campaign(food, 20, 8, DiscountType.Amount);
    Campaign campaign2 = new Campaign(food, 10, 3, DiscountType.Rate);
    Campaign campaign3 = new Campaign(electronic, 100, 2, DiscountType.Amount);

    @Test
    public void test_totalPureAmountShouldEqual() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(almond, 4);
        cart.addItem(huawei, 8);
        deliveryCostCalculator.calculateFor(cart);
        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        assertEquals(9600.0, cart.getTotalPrice());
    }

    @Test
    public void test_totalCouponDiscountShouldEqual() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(almond, 4);
        cart.addItem(huawei, 8);
        deliveryCostCalculator.calculateFor(cart);
        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        assertEquals(960.0, cart.getTotalCouponDiscount());
    }

    @Test
    public void test_totalCampaignDiscountShouldEqual() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(almond, 4);
        cart.addItem(huawei, 8);
        deliveryCostCalculator.calculateFor(cart);
        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        assertEquals(1080.0, cart.getTotalCampaignDiscount());
    }

    @Test
    public void test_deliveryCostShouldEqual() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(almond, 4);
        cart.addItem(huawei, 8);
        deliveryCostCalculator.calculateFor(cart);
        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        assertEquals(7.99, cart.getDeliveryCost());
    }

    @Test
    public void test_finalPriceShouldEqual() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 10);
        cart.addItem(almond, 4);
        cart.addItem(huawei, 8);
        deliveryCostCalculator.calculateFor(cart);
        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        assertEquals(7560.00, cart.calculateFinalPrice());
    }
}
