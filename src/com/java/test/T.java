package com.java.test;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
		System.out.println("\n----1-Group by...");
		Map<Dish.Type, List<Dish>> listDishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType, toList()));
		listDishesByType.entrySet().stream()
			.forEach(e -> {
			System.out.println("e.getKey: " + e.getKey()
							+ " value(s): " + e.getValue());
		});
		  
//		//-----------------------------------------------------------------------------------------------------------------    
//		System.out.println("\n----2-Group by...");
//		listDishesByType.entrySet().stream()
//						.map(  e ->  	e.getKey() 
//										+ " " 
//										+ (e.getValue().stream()
//													  .map(z -> z.getName())
//													  .collect(Collectors.joining(","))) ;
//						))
//						.forEach(System.out::println);

						
		//-----------------------------------------------------------------------------------------------------------------    
		System.out.println("\n----3-Group by...");
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				groupingBy(dish -> {
				if (dish.getCalories() <= 400) return CaloricLevel.DIET;
				else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
				else return CaloricLevel.FAT;
				} ));
		Map<CaloricLevel, List<Dish>> listDishesByType2 = menu.stream().collect(
																groupingBy( dish -> {
															   	if (dish.getCalories() <= 400) return CaloricLevel.DIET;
																else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
														   		else return CaloricLevel.FAT;
														   } ));
		listDishesByType2.entrySet().stream()
			.forEach(e -> {
			System.out.println("e.getKey: " + e.getKey()
							+ " value(s): " + e.getValue());
		});
		  
		//-----------------------------------------------------------------------------------------------------------------    
		System.out.println("\n----4-Group by...");
		Map<Dish.Type, List<Dish>> listDishesByType3 = menu.stream()
															.collect(Collectors.groupingBy(Dish::getType,
																						   filtering(d -> d.getCalories() > 500, toList())
																						   ));
		listDishesByType3.entrySet().stream()
			.forEach(e -> {
			System.out.println("e.getKey: " + e.getKey()
							+ " value(s): " + e.getValue());
		});
		  

		//-----------------------------------------------------------------------------------------------------------------    
		System.out.println("\n----5-Group by...");
		
		Map<String, List<String>> dishTags = new HashMap<>();
		dishTags.put("pork", Arrays.asList("greasy", "salty"));
		dishTags.put("beef", Arrays.asList("salty", "roasted"));
		dishTags.put("chicken", Arrays.asList("fried", "crisp"));
		dishTags.put("french fries", Arrays.asList("greasy", "fried"));
		dishTags.put("rice", Arrays.asList("light", "natural"));
		dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
		dishTags.put("pizza", Arrays.asList("tasty", "salty"));
		dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
		dishTags.put("salmon", Arrays.asList("delicious", "fresh"));
		
		Map<Dish.Type, Set<String>> listDishesByType4 = menu.stream()
															.collect(Collectors.groupingBy(Dish::getType,
																	Collectors.flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
																			Collectors.toSet())));
		listDishesByType4.entrySet().stream()
			.forEach(e -> {
			System.out.println("e.getKey: " + e.getKey()
							+ " value(s): " + e.getValue());
		});

	}	
	
}