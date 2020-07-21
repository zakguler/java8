package com.java.streams;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.java.Common_MODELS.Dish;


public class J9_Slicing_takeWhile_dropWhile {

	static List<Dish> specialMenu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static void main(String... args) {
		
		List<Dish> filteredMenu = specialMenu
				.stream()
				.takeWhile(dish -> dish.getCalories() < 320) // [must be a sorted list] +stops once a dish found >= 320
				.collect(toList());
		
		// find elements that have greater than 320 calories? 
		// You can use the dropWhile operation for this:
			List<Dish> slicedMenu2 = specialMenu
				.stream()
				.dropWhile(dish -> dish.getCalories() < 320) // [must be a sorted list] +finds dish that > 320
				.collect(toList());
			
	}
}
