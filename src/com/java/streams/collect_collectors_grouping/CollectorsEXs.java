package com.java.streams.collect_collectors_grouping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;

public class CollectorsEXs {

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

		
		
		
		
		System.out.println(" ");
		System.out.println("== 3.a Collectors.maxBy() =============");
		Comparator<Dish> comparatorDishByMaxCalories = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> maxOptDish = menu.stream()
						.collect(Collectors.maxBy(comparatorDishByMaxCalories));
						
		System.out.println("z..Collectors.maxBy: " + maxOptDish.get().getCalories());


		System.out.println(" ");
		System.out.println("== 3 mapToLong().max =============");
		OptionalLong maxOpt = menu.stream()
						.mapToLong(Dish::getCalories)
						.max();
						
		System.out.println("z..mapToLong(): " + maxOpt);

		
		System.out.println(" ");
		System.out.println("== 2 =============");
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
			.collect(Collectors.groupingBy(Dish::getType));	
		dishesByType.forEach( (k,v) -> {
			System.out.println(k + " " 
								 + v.stream().map(Dish::getName)
								 			 .collect(Collectors.joining(",")) );			
		});
		

		System.out.println(" ");
		System.out.println("== 1.a Collectors.counting() =============");
		long cnt2 = menu.stream().collect(Collectors.counting());
		System.out.println("z..counting(): " + cnt2);
		
		
		System.out.println(" ");
		System.out.println("== 1 count() =============");
		long cnt = menu.parallelStream().count();
		System.out.println("z..count(): " + cnt);
		
	}

}
