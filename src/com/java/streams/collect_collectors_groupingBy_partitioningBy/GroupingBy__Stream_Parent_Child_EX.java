package com.java.streams.collect_collectors_groupingBy_partitioningBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;

public class GroupingBy__Stream_Parent_Child_EX {

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

		
		Map<Dish.Type, List<Dish>> grpByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		grpByType.forEach((k,v) -> {
			System.out.println("Key type: " + k);
			v.forEach(d -> {
				System.out.print(" do somthing with name: " + d.getName());
				System.out.print(" and its calories: " + d.getCalories());
				System.out.println("");
			});
		});
	}

}
