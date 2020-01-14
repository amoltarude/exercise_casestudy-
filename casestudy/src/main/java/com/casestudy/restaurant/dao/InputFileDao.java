package com.casestudy.restaurant.dao;

import java.util.List;

import com.casestudy.restaurant.model.Dishes;
import com.casestudy.restaurant.model.Restaurant;
import com.casestudy.restaurant.model.Review;

public interface InputFileDao {

	public List<Restaurant> getAllRestaurants(List<String> filePathList);
	
	public List<Review> getReviews(Restaurant restaurant,String filePathStr);
	
	public List<Dishes> getDishes(Restaurant restaurant,String filePathStr);
}
