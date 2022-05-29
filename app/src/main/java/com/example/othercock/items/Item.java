package com.example.othercock.items;

public class Item {
    private String title;
    private int iconResId;
    private String price;

    public Item(String title, int iconResId) {
        super();
        this.title = title;
        this.iconResId = iconResId;
    }
    public Item(String title, int iconResId, String price) {
        super();
        this.title = title;
        this.iconResId = iconResId;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResourceId() {
        return iconResId;
    }

    public void setIconResource(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

}