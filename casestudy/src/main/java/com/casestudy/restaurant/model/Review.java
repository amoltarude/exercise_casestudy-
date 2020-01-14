package com.casestudy.restaurant.model;

public class Review {

	private String restaurantId;
	private String restaurantReview;

	public Review(String restaurantId, String review) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantReview = review;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public String getReview() {
		return restaurantReview;
	}

}
