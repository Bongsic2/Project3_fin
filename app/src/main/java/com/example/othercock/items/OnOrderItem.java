package com.example.othercock.items;

public class OnOrderItem {
    private int productId;
    private String title;
    private String date;

    public OnOrderItem(int productId, String title, String date) {
        super();
        this.title = title;
        this.productId = productId;
        this.date = date;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProductId() {
        return productId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }


}