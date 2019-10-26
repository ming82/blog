package com.sf.blogserver.bean;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryArticles;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getCategoryArticles() {
        return categoryArticles;
    }

    public void setCategoryArticles(Integer categoryArticles) {
        this.categoryArticles = categoryArticles;
    }
}
