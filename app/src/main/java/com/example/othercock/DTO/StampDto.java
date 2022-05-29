package com.example.othercock.DTO;

import java.util.Date;

public class StampDto {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StampDto{" +
                "date='" + date + '\'' +
                '}';
    }
}
