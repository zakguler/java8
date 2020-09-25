package com.java.streams.optional_Int_Double_Long;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.Common_MODELS.Dish;

public class OptionalInt_EX {

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

		//
		// Optional vs Primitive
		//
		
		// primitive stream
		IntStream calories = menu.stream()
				 .mapToInt(Dish::getCalories);
		
		// back to stream of objects
		Stream<Integer> caloriesObj = calories.boxed();
		
		// OptionalInt / max()
		OptionalInt maxCalories = menu.stream()
				 .mapToInt(Dish::getCalories)
				 .max();
		
		// OptionalInt / orElse()
		int maxCaloriesInt = menu.stream()
		 .mapToInt(Dish::getCalories)
		 .max().orElse(1);

	}

}
