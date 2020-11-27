package com.java.streams.collect_collectors_groupingBy_partitioningBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;
import com.java.Common_MODELS.Dish.Type;

public class GroupingBy_TOTAL_summingInt_counting_maxBy_filtering_mapping_flatMapping__with_lambda {
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

		
	 static Map<String, List<String>> dishTags = new HashMap<>();
	 static {
			  dishTags.put("pork", Arrays.asList("greasy", "salty"));
			  dishTags.put("beef", Arrays.asList("salty", "roasted"));
			  dishTags.put("chicken", Arrays.asList("fried", "crisp"));
			  dishTags.put("french fries", Arrays.asList("greasy", "fried"));
			  dishTags.put("rice", Arrays.asList("light", "natural"));
			  dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
			  dishTags.put("pizza", Arrays.asList("tasty", "salty"));
			  dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
			  dishTags.put("salmon", Arrays.asList("delicious", "fresh"));
	 }

	
	public enum CaloricLevel { DIET, NORMAL, FAT };
	
	public static void main(String[] args) {

		System.out.println("\n=====================================================");
		System.out.println("-----groupingBy [maxBy]... collecting data in subgroup ");

		Map<Dish.Type, Dish> mostCaloricByType =
				 menu.stream()
				 .collect(Collectors.groupingBy(
						 			 Dish::getType
									 ,Collectors.collectingAndThen( Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
											 						,Optional::get)
									 )); 
		
		mostCaloricByType.forEach((k, v) -> {
			System.out.println(k + ": " + v.getName());
		});

		
		System.out.println("\n=====================================================");
		System.out.println("-----groupingBy [counting]... collecting data in subgroup ");
		
		Map<Type, Long> typesCount = 
				menu.stream()
				.collect(Collectors.groupingBy(Dish::getType
						,Collectors.counting() 
						));
		
		typesCount.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----collecting data in subgroup [total][summingInt]");
		System.out.println("-----groupingBy with typeByToalCalories [summingInt] (instead of Dish's get total calories");
		
		Map<Type, Integer> typeByToalCalories = 
				menu.stream()
				.collect(Collectors.groupingBy(Dish::getType
						,Collectors.summingInt(Dish::getCalories) 
						));
		
		typeByToalCalories.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
		
		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----groupingBy with flatMapping... toList");
		
		Map<Dish.Type, Set<String>> dishNamesByType =
				menu.stream()
				.collect(Collectors.groupingBy(Dish::getType,
						 Collectors .flatMapping(dish -> dishTags.get( dish.getName() ) .stream()
								 				 ,Collectors.toSet())
						 ));
		dishNamesByType.forEach((k, v) -> {
			System.out.print(k + ": ");
			System.out.println(v.stream().collect(Collectors.joining(", ")));
		});

		
		System.out.println("\n=====================================================");
		System.out.println("-----groupingBy with mapping (instead of Dish's get Strings [names]");
		
		Map<Type, List<String>> mappingByNames = 
				menu.stream()
				.collect(Collectors.groupingBy(Dish::getType
						,Collectors.mapping(d->d.getName(),  Collectors.toList()) 
					));

		mappingByNames.forEach((k, v) -> {
			System.out.print(k + ": ");
			System.out.println(v.stream().collect(Collectors.joining(", ")));
		});
		
		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----groupingBy with mapping: toSet() ");
		System.out.println("-----groupingBy with mapping: toCollection(HashSet::new) ");
		
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = 
				menu.stream().collect(
						 Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
						 if (dish.getCalories() <= 400) return CaloricLevel.DIET;
						 else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
						 else return CaloricLevel.FAT; },
						 Collectors.toSet() )));

		caloricLevelByType.forEach((k, v) -> {
			System.out.print(k + ": ");
			System.out.println(v.stream().map(e->String.valueOf(e)).collect(Collectors.joining(", ")));
		});
		
//		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
//				menu.stream().collect(
//				 groupingBy(Dish::getType, mapping(dish -> {
//				 if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//				 else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//				 else return CaloricLevel.FAT; },
//				 toCollection(HashSet::new) )));
		
		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----groupingBy with filtering");
		
		Map<Type, List<Dish>> filteredByCalories = 
				menu.stream()
				.collect(Collectors.groupingBy(Dish::getType
						,Collectors.filtering(d->d.getCalories()>500,  Collectors.toList()) 
					));

		filteredByCalories.forEach((k, v) -> {
			System.out.print(k + ": ");
			System.out.println(v.stream().map(e -> String.valueOf(e.getCalories())).collect(Collectors.joining(", ")));
		});

		
		
		
		System.out.println("\n=====================================================");
		System.out.println("-----new TYPE and using lambda");

		Map<CaloricLevel, List<Dish>> caloricByLevel = 
				menu.stream()
				.collect(Collectors.groupingBy(d ->
					{
						if (d.getCalories() <= 400)
							return CaloricLevel.DIET;
						else if (d.getCalories() <= 700)
							return CaloricLevel.NORMAL;
						else
							return CaloricLevel.FAT;
					}
					));

		caloricByLevel.forEach((k, v) -> {
			System.out.print(k + ": ");
			System.out.println(v.stream().map(e -> String.valueOf(e.getCalories())).collect(Collectors.joining(", ")));
		});

		System.out.println("\n=====================================================");
		System.out.println("-----list calolies by type");
		Map<Dish.Type, List<Dish>> caloricByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));

		caloricByType.forEach((k, v) -> {
			System.out.print(k + ": ");
			System.out.println(v.stream().map(e -> String.valueOf(e.getCalories())).collect(Collectors.joining(", ")));
		});

	}

}

