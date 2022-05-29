package com.example.othercock.ui.other;

public class NewMenu {
    private String title;
    private int iconResId;

    public NewMenu(String title, int iconResId) {
        super();
        this.title = title;
        this.iconResId = iconResId;
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
}
