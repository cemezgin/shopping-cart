package com.app.entity;

public class Product {
    private String title;
    private double price;
    private Category category;

    public Product(String title, double price, Category category) {
        this.setTitle(title);
        this.setPrice(price);
        this.setCategory(category);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
