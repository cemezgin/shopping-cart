package com.app.service.cart;

import com.app.entity.*;
import com.app.entity.discount.*;
import com.app.service.calculator.*;

import java.util.*;

public class ShoppingCart {
    private final Set<CartItem> shoppingCart = new HashSet<>();
    private final List<Campaign> campaignSet = new ArrayList<>();
    private double totalPrice = 0.0;
    private double totalDiscountAmount = 0.0;
    private double totalCouponDiscount = 0.0;
    private double totalCampaignDiscount = 0.0;
    private double deliveryCost = 0.0;

    public void setTotalDiscountAmount(double totalPrice) {
        this.totalDiscountAmount = totalPrice;
    }

    public double getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalCouponDiscount(double totalCouponDiscount) {
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
        setTotalPrice(getTotalPrice() + (product.getPrice() * quantity));
        this.shoppingCart.add(item);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Set<CartItem> getShoppingCart() {
        return this.shoppingCart;
    }

    public void applyDiscounts(Campaign... campaigns) {
        this.campaignSet.addAll(Arrays.asList(campaigns));
        campaignSet.forEach(campaign -> {
            Calculator calculator = new Calculator(new CampaignCalculator(this, campaign));
            calculator.calculate();
        });
    }

    public void applyCoupon(Coupon coupon) {
        Calculator calculator = new Calculator(new CouponCalculator(this, coupon));
        calculator.calculate();
    }

    private HashMap<Category, Set<CartItem>> getCategorizedShoppingCart() {
        HashMap<Category, Set<CartItem>> categorizedShoppingCart = new HashMap<>();
        getShoppingCart().forEach(cartItem -> {
            Category category = cartItem.getProduct().getCategory();

            if (!categorizedShoppingCart.containsKey(category)) {
                categorizedShoppingCart.put(category, new HashSet<>());
            }

            categorizedShoppingCart.get(category).add(cartItem);

        });

        return categorizedShoppingCart;
    }

    public double calculateFinalPrice() {
        return getTotalDiscountAmount() + getTotalPrice();
    }

    public void print() {
        HashMap<Category, Set<CartItem>> categorizedShoppingCart = getCategorizedShoppingCart();
        double finalPrice = calculateFinalPrice() + getDeliveryCost();

        categorizedShoppingCart.forEach((category, cartItems) -> {
            System.out.println("------ Category: " + category.getTitle() + " ------");
            cartItems.forEach(cartItem -> {
                double price = cartItem.getProduct().getPrice();
                double quantity = cartItem.getQuantity();
                System.out.println("|||-- Product: " + cartItem.getProduct().getTitle() + "--|||");
                System.out.println("Quantity: " + quantity);
                System.out.println("Unit Price: " + price);
                System.out.println("Total Price: " + price * quantity);
            });
        });

        System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
        System.out.println("+Total Amount: " + getTotalPrice());
        System.out.println("-Total Coupon Discount: " + getTotalCouponDiscount());
        System.out.println("-Total Campaign Discount: " + getTotalCampaignDiscount());
        System.out.println("+Delivery Cost: " + getDeliveryCost());
        System.out.println("=");
        System.out.println("Final Price: " + finalPrice);
    }
}
