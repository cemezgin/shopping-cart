package com.app.entity;

public class Category {
    private String title;
    private Category parentCategory;

    public Category(String title) {
        this.setTitle(title);
    }

    public Category(String title, Category parentCategory) {
        this.setTitle(title);
        this.setParentCategory(parentCategory);
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
