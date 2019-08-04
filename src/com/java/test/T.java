package com.java.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

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

	public enum CaloricLevel {DIET, NORMAL, FAT};
	
	public static void main(String[] args) {
		
		  //-----------------------------------------------------------------------------------------------------------------    
		  System.out.println("\n-----Group by...");
		  
		  Map<Dish.Type, List<Dish>> m = menu.stream()
				  						  .collect(groupingBy(Dish::getType));
		  
		  m.forEach( (k,v) -> System.out.println(k + ": " + (v.toString())) );
				  	  
		  
		  //-----------------------------------------------------------------------------------------------------------------    
		  System.out.println("\n-----");
		  
		  Map<CaloricLevel, List<Dish>> m2 = menu.stream()
					  .collect(groupingBy(dish -> {
						  if (dish.getCalories() <= 400) return CaloricLevel.DIET;
						  else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
						  else return CaloricLevel.FAT;
					  }));
		  
		  m2.forEach( (k,v) -> System.out.println(k + ": " + (v.toString())) );
		  //-----------------------------------------------------------------------------------------------------------------    
		  System.out.println("\n-----");
		  
		  Map<Dish.Type, List<Dish>> m3 = menu.stream()
				  .collect(groupingBy(Dish::getType,
						  			  filtering(dish -> dish.getCalories() > 500, toList())));
		  m3.forEach( (k,v) -> System.out.println(k + ": " + (v.toString())) );

				  
		  //-----------------------------------------------------------------------------------------------------------------    
		  System.out.println("\n-----");
		  
		  Map<Dish.Type, List<String>> m4 = menu.stream()
				  .collect(groupingBy(Dish::getType,
						  			  mapping(Dish::getName, toList())));
		  m4.forEach( (k,v) -> System.out.println(k + ": " + (v.toString())) );

		  //-----------------------------------------------------------------------------------------------------------------    
		  System.out.println("\n-----");
		  
		  Map<Dish.Type, List<String>> m5 = menu.stream()
				  .collect(groupingBy(Dish::getType,
						  			  mapping(Dish::getName, toList())));
		  m5.forEach( (k,v) -> System.out.println(k + ": " + (v.toString())) );
				  
				  
		  
	}	
	
}
