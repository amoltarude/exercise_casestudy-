package com.casestudy.restaurant.model;

import java.time.LocalTime;
import java.util.List;

public class Restaurant {

	private String restaurantId;
	private String restaurantName;
	private String ratings;
	private LocalTime openingTime;
	private LocalTime closingTime;
	private List<Review> reviews;
	private List<Dishes> dishes;
	
	
	
	public Restaurant(String restaurantId, String restaurantName, String ratings, LocalTime openingTime,
			LocalTime closingTime, List<Review> reviews, List<Dishes> dishes) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.ratings = ratings;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.reviews = reviews;
		this.dishes = dishes;
	}
	
	public String getRestaurantId() {
		return restaurantId;
	}
	

	public String getRestaurantName() {
		return restaurantName;
	}
	
	
	public String getRatings() {
		return ratings;
	}
	

	
	public LocalTime getOpeningTime() {
		return openingTime;
	}
	

	
	public LocalTime getClosingTime() {
		return closingTime;
	}
	

	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public List<Dishes> getDishes() {
		return dishes;
	}
	
	public void setDishes(List<Dishes> dishes) {
		this.dishes = dishes;
	}


	
}
