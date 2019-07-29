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
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("seasonal fruit", true, 120, Dish.Type.OTHER)
			);

	
	public static void main(String[] args) {
		
		Comparator<Dish> dishCaloriesComparator =
				Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish = menu.stream()
											 .collect(maxBy(dishCaloriesComparator));
	    System.out.println(mostCalorieDish); 
	    
	    System.out.println("--------------------------------------");
	    int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
//	    double totalCalories = menu.stream().collect(summingDouble(Dish::getCalories));
	    System.out.println(totalCalories); 	    
	    System.out.println("--------------------------------------");
	    System.out.println(menu.stream().mapToInt(Dish::getCalories).sum() );

	    System.out.println("--------------------------------------");
	    double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
	    System.out.println( avgCalories );

	    System.out.println("--------------------------------------");
	    IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
	    System.out.println( menuStatistics );
	    
	    

	}	
	
	
}
