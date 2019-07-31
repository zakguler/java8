package com.java.test;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import com.java.Common_MODELS.Dish;

// Functional programming: using Predicate

public class T {

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
		
		  //-----------------------------------------------------------------------------------------------------------------    
		  System.out.println("\n-----Group by...");
		  
		  Map<String, List<Dish>> 
	    
	    page 146
	    6.3 grouping

	}	
	
	
}
