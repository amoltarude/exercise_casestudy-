package com.casestudy.restaurant.utility;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.casestudy.restaurant.model.Dishes;
import com.casestudy.restaurant.model.Restaurant;
import com.casestudy.restaurant.model.Review;

public class RestaurantUtils {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantUtils.class);
	
	private  RestaurantUtils() {
	}
	
	public static Restaurant parseRestaurant(String line) {
		
		String[] strArr = line.split(",");
		
		logger.debug(line);
		
		return new Restaurant(strArr[0], strArr[1], strArr[2], LocalTime.parse(strArr[3],DateTimeFormatter.ofPattern("HH:mm:ss")), LocalTime.parse(strArr[4],DateTimeFormatter.ofPattern("HH:mm:ss")), null, null); 
		
	}
	
	public static Review parseReview(String line) {
		
		String[] strArr = line.split(",");
		
		logger.debug(line);
		
		return new Review(strArr[0], strArr[1]);
		
	}
	
	public static Dishes parseDish(String line) {
		
		String[] strArr = line.split(",");
		
		logger.debug(line);
		
		return new Dishes(strArr[0], strArr[1], Double.parseDouble(strArr[2]), Double.parseDouble(strArr[3]));
		
	}
}
