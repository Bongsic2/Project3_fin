package com.example.othercock.DTO;

import java.util.Objects;

public class OrderMenu {
    private int Resource;
    private String name;
    private String index;
    private int price;
    private int kcal;
    private String allregy;
    private int number;

    public int getResource() {
        return Resource;
    }

    public void setResource(int resource) {
        Resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getAllregy() {
        return allregy;
    }

    public void setAllregy(String allregy) {
        this.allregy = allregy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMenu orderMenu = (OrderMenu) o;
        return Objects.equals(name, orderMenu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "name='" + name + '\'' +
                ", index='" + index + '\'' +
                ", price=" + price +
                ", kcal=" + kcal +
                ", allregy='" + allregy + '\'' +
                ", number=" + number +
                '}';
    }
}

