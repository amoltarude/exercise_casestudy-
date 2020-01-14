package com.casestudy.restaurant.model;

public class Dishes {

	private String restaurantId;
	private String dishName;
	private double price;
	private double discount;
	
	public Dishes(String restaurantId, String dishName, double price, double discount) {
		super();
		this.restaurantId = restaurantId;
		this.dishName = dishName;
		this.price = price;
		this.discount = discount;
	}
	
	public String getRestaurantId() {
		return restaurantId;
	}
	public String getDishName() {
		return dishName;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}
	
	
}
