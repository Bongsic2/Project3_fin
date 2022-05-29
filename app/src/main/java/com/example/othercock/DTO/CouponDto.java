package com.example.othercock.DTO;

public class CouponDto {
    private int coupon_image;
    private String coupon_date;

    public CouponDto( String coupon_date) {
        super();
        this.coupon_image = coupon_image;
        this.coupon_date = coupon_date;
    }

    public int getCoupon_image() {
        return coupon_image;
    }

    public void setCoupon_image(int coupon_image) {
        this.coupon_image = coupon_image;
    }

    public String getCoupon_date() {
        return coupon_date;
    }

    public void setCoupon_date(String coupon_date) {
        this.coupon_date = coupon_date;
    }
}
