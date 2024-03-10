package com.softskillz.models;

import java.time.LocalDateTime;

public class Coupon {
    private int couponId;
    private String couponCode;
    private String couponDescription;
    private Integer couponUsageLimit;
    private String couponUsageStatus;
    private LocalDateTime couponValidFrom;
    private LocalDateTime couponValidTo;
    private int couponDiscount;
    private String couponDiscountType;
    private String couponConditions;

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public Integer getCouponUsageLimit() {
        return couponUsageLimit;
    }

    public void setCouponUsageLimit(Integer couponUsageLimit) {
        this.couponUsageLimit = couponUsageLimit;
    }

    public String getCouponUsageStatus() {
        return couponUsageStatus;
    }

    public void setCouponUsageStatus(String couponUsageStatus) {
        this.couponUsageStatus = couponUsageStatus;
    }

    public LocalDateTime getCouponValidFrom() {
        return couponValidFrom;
    }

    public void setCouponValidFrom(LocalDateTime couponValidFrom) {
        this.couponValidFrom = couponValidFrom;
    }

    public LocalDateTime getCouponValidTo() {
        return couponValidTo;
    }

    public void setCouponValidTo(LocalDateTime couponValidTo) {
        this.couponValidTo = couponValidTo;
    }

    public int getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(int couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponDiscountType() {
        return couponDiscountType;
    }

    public void setCouponDiscountType(String couponDiscountType) {
        this.couponDiscountType = couponDiscountType;
    }

    public String getCouponConditions() {
        return couponConditions;
    }

    public void setCouponConditions(String couponConditions) {
        this.couponConditions = couponConditions;
    }
}
