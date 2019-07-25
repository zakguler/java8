package com.java.streams.reduce;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.java.Common_MODELS.Dish;

public class Reduce_sum {

	static List<Dish> specialMenu = Arrays.asList(
			new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER));
	
	public static void main(String... args) {
		
		Optional<Integer> ds = specialMenu
				.stream()
				.map(d -> 1)
				.reduce(Integer::sum);
		
		System.out.println("# od Dishes: " + ds.get());
			
		// same as [specialMenu.stream().count()]
		System.out.println("another way: " + specialMenu.stream().count());
	}
	
}
