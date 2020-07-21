package com.java.streams.map;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.java.Common_MODELS.Dish;

// using multiple .map(s)
public class MapMap {

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
		List<Integer> dishNameLengths = menu.stream()
				.map(Dish::getName)
				.map(String::length)
				.collect(toList());
	}
	

}
