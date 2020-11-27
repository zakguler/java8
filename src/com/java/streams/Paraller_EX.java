package com.java.streams;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.Common_MODELS.Dish;

// Functional programming: using Predicate

public class Paraller_EX {

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

	public enum CaloricLevel {DIET, NORMAL, FAT};
	
	
	public static void main(String[] args) {
		
		System.out.println("== 1 =============");
		long cnt = menu.parallelStream().count();
		System.out.println("z..Count: " + cnt);

		
		//-----------------------------------------------------------------------------------------------------------------    
		System.out.println("\n----...");

		long s = Stream.iterate(0L, i->i+1)
								.limit(5)
								.parallel()
								.reduce(0L, Long::sum);
		
		System.out.println(s);
		
		  
	}	
	
}