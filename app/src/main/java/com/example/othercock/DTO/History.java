package com.example.othercock.DTO;

import java.util.Date;

public class History {
	private String where;
	private int price;
	private String date;
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "History [where=" + where + ", price=" + price + ", date=" + date + "]";
	}
	
	
	
	
}
