package com.java.streams.collect_collectors_groupingBy_partitioningBy;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;

public class PartitioningBy__boolean_GroupingBy_MultiLevelEX {

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
		
		System.out.println("\n=====================================================");
		System.out.println("-----partitioningBy:");
		System.out.println("find the most caloric dish among both vegetarian and nonvegetarian dishes::");

		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
				menu.stream().collect(
				 partitioningBy(Dish::isVegetarian,
				 collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
				 Optional::get)));
		// That will produce the following result:
		// {false=pork, true=pizza}
		
		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----partitioningBy_n_groupingBy multi level ");

		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
				menu.stream().collect(
				 partitioningBy(Dish::isVegetarian,
				 groupingBy(Dish::getType))); 
		
		vegetarianDishesByType.forEach((k, v) -> {
			System.out.print(k + " (k): "); 
			v.forEach((k2,v2)->{
				System.out.print(k2 + " (k2): ");
				System.out.println(v2.stream().map(d->d.getName()).collect(Collectors.joining(", ")));
			});
			
		});
		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----partitioningBy isVegetarian ? ");

//		Map<Boolean, List<Dish>> partitioningByIsVegetarian =
//				 menu.stream()
//				 .collect(Collectors.partitioningBy(
//						 	dish -> dish.getType().equals(Dish.Type.OTHER)
//						 	)); 
		
		Map<Boolean, List<Dish>> partitioningByIsVegetarian =
				menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian)); 
		
		partitioningByIsVegetarian.forEach((k, v) -> {
			System.out.print(k + ": "); 
			System.out.println( v.stream().map(d->d.getName()).collect(Collectors.joining(", ")) );
		});


		List<Dish> vegetarianDishes = partitioningByIsVegetarian.get(true);
		
	}

}
