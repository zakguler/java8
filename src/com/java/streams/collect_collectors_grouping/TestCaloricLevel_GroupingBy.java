package com.java.streams.collect_collectors_grouping;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;
import com.java.Common_MODELS.Dish.Type;

enum CaloricLevel {DIET, NORMAL, FAT}

public class TestCaloricLevel_GroupingBy {

	public static void main(String[] args) {
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		//====
		System.out.println("\n===1");
		
		Map<Dish.Type, List<Dish>> dishesByType =  menu.stream().collect(Collectors.groupingBy(Dish::getType));
		
		dishesByType.forEach(
				(k,v) -> {
					System.out.print("\n" + k);
					v.forEach(e->System.out.print(" " + e.getName()));
				});

		//====
		System.out.println("\n===2");

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =  menu.stream()
				.collect(Collectors.groupingBy(
						dish -> {
							if (dish.getCalories() <= 400) return CaloricLevel.DIET;
							else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
							else return CaloricLevel.FAT;
						}));

		
		dishesByCaloricLevel.forEach(
				(k,v) -> {
					System.out.print("\n" + k);
					v.forEach(e->System.out.print(" " + e.getName()));
				});
	
		//====
		System.out.println("\n===3");

		Map<Type, List<Dish>> caloricDishesByType =  menu.stream()
				.collect(Collectors.groupingBy(Dish::getType,
						   filtering(d -> d.getCalories() > 500, toList())
						   ));
		
		caloricDishesByType.forEach(
				(k,v) -> {
					System.out.print("\n" + k);
					v.forEach(e->System.out.print(" " + e.getName()));
				});
	
		//====
		System.out.println("\n===4");

		Map<Dish.Type, Long> typesCount = menu.stream().collect(
				 groupingBy(Dish::getType, counting()));

		typesCount.forEach(
				(k,v) -> {
					System.out.print("\n" + k + "=" + v);
				});


	}

}
