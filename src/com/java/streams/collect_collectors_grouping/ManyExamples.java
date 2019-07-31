package com.java.streams.collect_collectors_grouping;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import com.java.Common_MODELS.Dish;

// Functional programming: using Predicate

public class ManyExamples {

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
		
		Comparator<Dish> dishCaloriesComparator =
				Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish = menu.stream()
											 .collect(maxBy(dishCaloriesComparator));
	    System.out.println(mostCalorieDish); 
	    
	    System.out.println("---summingInt()-----------------------------------");
	    int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
//	    double totalCalories = menu.stream().collect(summingDouble(Dish::getCalories));
	    System.out.println(totalCalories); 	    
	    System.out.println("---");
	    System.out.println(menu.stream().mapToInt(Dish::getCalories).sum() );

	    System.out.println("---averagingInt()---------------------------------");
	    double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
	    System.out.println( avgCalories );

	    System.out.println("---summarizingInt()-------------------------------");
	    IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
	    System.out.println( menuStatistics );
	    
	    System.out.println("---joining()--------------------------------------");
	    String shortMenu = menu.stream().map(Dish::getName).collect(joining());
	    System.out.println( shortMenu );
	    System.out.println("---");
	    String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));
	    System.out.println( shortMenu2 );
	    
	    System.out.println("---reducing()--------------------------------------");
	    int totalCalories0 = menu.stream().collect(
	    		reducing(0,			//....................... initial value
	    		Dish::getCalories,	//....................... transformation function
	    		Integer::sum));		//....................... aggregating function
	    System.out.println( totalCalories0 );
	    
	    System.out.println("---");
	    int totalCalories2 = menu.stream().collect(reducing( 0, Dish::getCalories, (i, j) -> i + j) );
	    System.out.println( totalCalories2 );
	    
	    System.out.println("---");
	    Optional<Dish> mostCalorieDish2 =
	    		menu.stream().collect(reducing(
	    		(d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
	    System.out.println(mostCalorieDish2); 
	    
	    
	}	
	
	
}
