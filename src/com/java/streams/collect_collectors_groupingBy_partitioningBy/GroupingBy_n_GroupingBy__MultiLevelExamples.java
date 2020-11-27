package com.java.streams.collect_collectors_groupingBy_partitioningBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;
import com.java.Common_MODELS.EmployeeSimple;

public class GroupingBy_n_GroupingBy__MultiLevelExamples {

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	};

	static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	static List<EmployeeSimple> employeeList = Arrays.asList(new EmployeeSimple("3333", "Tom Jones", 6),
			new EmployeeSimple("1111", "Harry Major", 7), new EmployeeSimple("5555", "Ethan Hardy", 6),
			new EmployeeSimple("3333", "Tom Jones", 4), new EmployeeSimple("5555", "Ethan Hardy", 4),
			new EmployeeSimple("1111", "Harry Major", 6), new EmployeeSimple("3333", "Tom Jones", 8),
			new EmployeeSimple("3333", "Tom Jones", 2));

	public static void main(String args[]) {

		System.out.println("\n-----Employee List:");
		employeeList.forEach(e -> System.out.println(e.toString()));

		System.out.println("\n-----Group Employee by id -List");
		Map<String, List<EmployeeSimple>> employeeMap = employeeList.stream()
				.collect(Collectors.groupingBy(EmployeeSimple::getId));

		employeeMap.forEach((String key, List<EmployeeSimple> empList) -> System.out.println(key + " -> " + empList));

		// -----------------------------------------------------------------------------------------------------------------
		System.out.println("\n-----Group by... ");

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

		Map<Dish.Type, Set<String>> dishNamesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType,
				Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(), Collectors.toSet())));

		// {MEAT=[salty, greasy, roasted, fried, crisp], FISH=[roasted, tasty, fresh,
		// delicious], OTHER=[salty, greasy, natural, light, tasty, fresh, fried]}

		dishNamesByType.forEach((k, v) -> {
			System.out.print(k + " = ");
			v.forEach(w -> System.out.print(w + ","));
			System.out.println();
		});

		// -----------------------------------------------------------------------------------------------------------------
		System.out.println("\n-----Multi-Level Group by... ");
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
				.collect(
						Collectors.groupingBy(
							Dish::getType
							, Collectors.groupingBy(dish -> {
								if (dish.getCalories() <= 400)
									return CaloricLevel.DIET;
								else if (dish.getCalories() <= 700)
									return CaloricLevel.NORMAL;
								else
									return CaloricLevel.FAT;
				})));
		// {MEAT={DIET=[chicken], NORMAL=[beef], FAT=[pork]},
		// FISH={DIET=[prawns], NORMAL=[salmon]},
		// OTHER={DIET=[rice, seasonal fruit], NORMAL=[french fries, pizza]}}

	}
}