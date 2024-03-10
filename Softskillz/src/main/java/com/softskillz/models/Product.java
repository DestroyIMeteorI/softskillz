package com.softskillz.models;

import java.time.LocalDateTime;

public class Product {
    private int productId; 
    private String productName;
    private String productDescription;
    private int categoryId;
    private int productPrice;
    private int productStock;
    private String productImageUrl;
    private String productTargetAudience;
    private LocalDateTime productCreateDate;
    private LocalDateTime productUpdateDate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductTargetAudience() {
        return productTargetAudience;
    }

    public void setProductTargetAudience(String productTargetAudience) {
        this.productTargetAudience = productTargetAudience;
    }

    public LocalDateTime getProductCreateDate() {
        return productCreateDate;
    }

    public void setProductCreateDate(LocalDateTime productCreateDate) {
        this.productCreateDate = productCreateDate;
    }

    public LocalDateTime getProductUpdateDate() {
        return productUpdateDate;
    }

    public void setProductUpdateDate(LocalDateTime productUpdateDate) {
        this.productUpdateDate = productUpdateDate;
    }
}
