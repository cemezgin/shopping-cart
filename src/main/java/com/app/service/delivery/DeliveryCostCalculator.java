package com.app.service.delivery;

import com.app.entity.CartItem;
import com.app.entity.Category;
import com.app.service.cart.ShoppingCart;

import java.util.*;

public class DeliveryCostCalculator {
    public static final double FIXED_COST = 2.99;

    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost;

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct, double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    public void calculateFor(ShoppingCart cart) {
        double deliveryCost = calculate(
                calculateNumberOfDeliveries(cart.getShoppingCart()), cart.getShoppingCart().size());
        cart.setDeliveryCost(deliveryCost);
    }

    private double calculate(int numberOfDeliveries, int numberOfProducts) {
        return (costPerDelivery * numberOfDeliveries) + (costPerProduct * numberOfProducts) + fixedCost;
    }

    private int calculateNumberOfDeliveries(Set<CartItem> cartItems) {
        Set<Category> categoryHashSet = new HashSet<>();

        cartItems.forEach(cartItem -> {
            categoryHashSet.add(cartItem.getProduct().getCategory());
        });

        return categoryHashSet.size();
    }

}
