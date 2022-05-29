package com.example.othercock.items;

public class StoreInfoItem {
    private int storeId;
    private String storename;
    private String storeaddr;
    private float storelatitude;
    private float storelongitude;

    public StoreInfoItem(int storeId, String storename, String storeaddr, float storelatitude, float storelongitude) {
        super();
        this.storeId = storeId;
        this.storename = storename;
        this.storeaddr = storeaddr;
        this.storelatitude=storelatitude;
        this.storelongitude=storelongitude;

    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStoreaddr() {
        return storeaddr;
    }

    public void setStoreaddr(String storeaddr) {
        this.storeaddr = storeaddr;
    }

    public float getStorelatitude() { return storelatitude; }

    public void setStorelatitude(float storelatitude) { this.storelatitude = storelatitude; }

    public float getStorelongitude() { return storelongitude; }

    public void setStorelongitude(float storelongitude) { this.storelongitude = storelongitude; }
}
