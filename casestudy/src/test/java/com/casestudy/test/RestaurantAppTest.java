package com.casestudy.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.casestudy.main.RestaurantApp;
import com.casestudy.restaurant.model.Restaurant;

public class RestaurantAppTest {
	private RestaurantApp restaurant;

	@Before
	public void setUp() {

		restaurant = new RestaurantApp();
	}

	@Test
	public void testAllRestaurants() {
		List<Restaurant> allRestaurants = restaurant.retrieveAllRestaturants();

		assertEquals(2, allRestaurants.size());
	}

	@Test
	public void testGetReviews() {

		List<Restaurant> allRestaurants = restaurant.retrieveRestaurantsBasedOnRating();

		assertEquals(2, allRestaurants.size());
	}

	@Test
	public void testAvailablity() {

		List<Restaurant> allRestaurants = restaurant.retriveAvailabilityBasedTiming();

		assertEquals(2, allRestaurants.size());
	}
}