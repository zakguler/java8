package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;

public class Filter_takeWhile_dropWhile_EX {

	static List<Dish> specialMenu = Arrays.asList(
			 new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
			 new Dish("prawns", false, 300, Dish.Type.FISH),
			 new Dish("rice", true, 350, Dish.Type.OTHER),
			 new Dish("chicken", false, 400, Dish.Type.MEAT),
			 new Dish("french fries", true, 530, Dish.Type.OTHER));
	
	
	public static void main(String[] args) {

		// [already sorted elements] use to stop (selecting) filtering when it is true
		List<Dish> filteredMenu
		 = specialMenu.stream()
		 .takeWhile(dish -> dish.getCalories() < 320)
		 .collect(Collectors.toList()); 
		
		filteredMenu.forEach(System.out::println);
		
		System.out.println("====");
		
		// [already sorted elements] use to select filtering when the ones that's not true [the opposite of .takeWhile]
		List<Dish> filteredMenu2
		 = specialMenu.stream()
		 .dropWhile(dish -> dish.getCalories() < 320)
		 .collect(Collectors.toList()); 
		
		filteredMenu2.forEach(System.out::println);
		
		
	}

}
