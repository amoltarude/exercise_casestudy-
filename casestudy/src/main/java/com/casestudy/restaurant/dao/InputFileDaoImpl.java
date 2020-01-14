package com.casestudy.restaurant.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.casestudy.restaurant.model.Dishes;
import com.casestudy.restaurant.model.Restaurant;
import com.casestudy.restaurant.model.Review;
import com.casestudy.restaurant.utility.RestaurantUtils;

public class InputFileDaoImpl implements InputFileDao {

	private static final Logger logger = LoggerFactory.getLogger(InputFileDaoImpl.class);
	
	@Override
	public List<Restaurant> getAllRestaurants(List<String> filePathList) {
		
		String[] fileNameArr = filePathList.get(0).split("/");
		
		Path filePath = Paths.get(fileNameArr[0], fileNameArr[1],fileNameArr[2]);
		
		List<Restaurant> restaurantList = new ArrayList<>();
		
		try(Stream<String> lines = Files.newBufferedReader(filePath).lines()){
			
			restaurantList = lines.map(RestaurantUtils::parseRestaurant).collect(Collectors.toCollection(ArrayList::new));
			
			restaurantList.stream().forEach(res -> {
				res.setReviews(getReviews(res, filePathList.get(1)));
				
				res.setDishes(getDishes(res, filePathList.get(2)));
			});
			
		}catch (IOException e) {
			
			logger.error(e.getMessage());
			
		}
		
		return restaurantList;
	}

	@Override
	public List<Review> getReviews(Restaurant restaurant, String filePathStr) {
		
		String[] fileNameArr = filePathStr.split("/");
		
		Path filePath = Paths.get(fileNameArr[0], fileNameArr[1],fileNameArr[2]);
		
		List<Review> reviewList = new ArrayList<>();
		
		try(Stream<String> lines = Files.newBufferedReader(filePath).lines()){
			
			reviewList = lines.map(RestaurantUtils::parseReview).collect(Collectors.toCollection(ArrayList::new));
			
			
			
		}catch (IOException e) {
			
			logger.error(e.getMessage());
			
		}
		
		return reviewList.stream()
				.filter(r -> r.getRestaurantId()
				.equals(restaurant.getRestaurantId()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Dishes> getDishes(Restaurant restaurant, String filePathStr) {
		
		String[] fileNameArr = filePathStr.split("/");
		
		Path filePath = Paths.get(fileNameArr[0], fileNameArr[1],fileNameArr[2]);
		
		List<Dishes> dishList = new ArrayList<>();
		
		try(Stream<String> lines = Files.newBufferedReader(filePath).lines()){
			
			dishList = lines.map(RestaurantUtils::parseDish).collect(Collectors.toCollection(ArrayList::new));
			
			
			
		}catch (IOException e) {
			
			logger.error(e.getMessage());
			
		}
		
		return dishList.stream()
				.filter(r -> r.getRestaurantId()
				.equals(restaurant.getRestaurantId()))
				.collect(Collectors.toList());
	}

	

}
