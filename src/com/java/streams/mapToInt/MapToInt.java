package com.java.streams.mapToInt;

import java.util.Arrays;
import java.util.List;

import com.java.Common_MODELS.Dish;

public class MapToInt {

	static List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );


	public static void main(String[] args) {

		int totalCalories =
				menu.stream().mapToInt(Dish::getCalories).sum();
		
		System.out.println(totalCalories);
	}

}
