package com.casestudy.main;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.casestudy.restaurant.dao.InputFileDaoImpl;
import com.casestudy.restaurant.model.Restaurant;

public class RestaurantApp {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantApp.class);

	InputFileDaoImpl inputFileDaoImpl = new InputFileDaoImpl();

	List<String> filePathList = Arrays.asList("data/input/restaurant.csv", "data/input/review.csv",
			"data/input/dishes.csv");

	public List<Restaurant> retrieveAllRestaturants() {
		logger.info("Inside  retrieveAllRestaturants");
		return inputFileDaoImpl.getAllRestaurants(filePathList);
	}

	public List<Restaurant> retrieveRestaurantsBasedOnRating() {
		logger.info("Inside  retrieveRestaurantsBasedOnRating");
		List<Restaurant> allRestaurants = inputFileDaoImpl.getAllRestaurants(filePathList);
		allRestaurants.parallelStream().filter(res -> Double.parseDouble(res.getRatings()) < 4.0
		).collect(Collectors.toList());

		return allRestaurants;
	}

	public List<Restaurant> retriveAvailabilityBasedTiming() {
		logger.info("Inside  retriveAvailabilityBasedTiming");
		List<Restaurant> allRestaurants = inputFileDaoImpl.getAllRestaurants(filePathList);

		allRestaurants.parallelStream().filter(res -> {
			LocalTime now = LocalTime.now();
			return res.getOpeningTime().isAfter(now) && res.getClosingTime().isBefore(now);
		}).collect(Collectors.toList());

		return allRestaurants;
	}

}
