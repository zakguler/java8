package com.java.streams.arrays_asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.Common_MODELS.Dish;

public class Arrays_asList_EX {

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

		// How to add elements in List when used Arrays.asList()
		List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
		
		// OR
		List<String> list2 = Stream.of("a", "b", "c")
								.collect(Collectors.toList());
		
		//===============================
		
		
		
	}

}
