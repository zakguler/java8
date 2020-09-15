package com.java.streams;

import java.util.Arrays;
import java.util.List;

import com.java.Common_MODELS.Dish;
import static java.util.stream.Collectors.toList;

public class Filter_limit_EX {

	static List<Dish> specialMenu = Arrays.asList(
			 new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
			 new Dish("prawns", false, 300, Dish.Type.FISH),
			 new Dish("rice", true, 350, Dish.Type.OTHER),
			 new Dish("chicken", false, 400, Dish.Type.MEAT),
			 new Dish("french fries", true, 530, Dish.Type.OTHER));
	

	public static void main(String[] args) {
		
		List<Dish> dishes = specialMenu
				 .stream()
				 .filter(dish -> dish.getCalories() > 300)
				 .limit(3)
				 .collect(toList());
		
		dishes.forEach(System.out::println);

	}

}
