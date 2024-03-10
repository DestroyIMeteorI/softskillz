package com.softskillz.models;

public class Merchandise {
    private int merchandiseId;
    private int productId;
    private String merchandiseName;
    private int merchandisePrice;
    private int merchandiseStockQuantity;
    private String merchandiseDescription;
    private String merchandiseImageUrl;

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

    public int getMerchandisePrice() {
        return merchandisePrice;
    }

    public void setMerchandisePrice(int merchandisePrice) {
        this.merchandisePrice = merchandisePrice;
    }

    public int getMerchandiseStockQuantity() {
        return merchandiseStockQuantity;
    }

    public void setMerchandiseStockQuantity(int merchandiseStockQuantity) {
        this.merchandiseStockQuantity = merchandiseStockQuantity;
    }

    public String getMerchandiseDescription() {
        return merchandiseDescription;
    }

    public void setMerchandiseDescription(String merchandiseDescription) {
        this.merchandiseDescription = merchandiseDescription;
    }

    public String getMerchandiseImageUrl() {
        return merchandiseImageUrl;
    }

    public void setMerchandiseImageUrl(String merchandiseImageUrl) {
        this.merchandiseImageUrl = merchandiseImageUrl;
    }
}
