package com.java.streams.printHashMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;

public class PrintMapListCollectrsJoining {

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

		System.out.println("== 2 =============");
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
			.collect(Collectors.groupingBy(Dish::getType));	
		dishesByType.forEach( (k,v) -> {
			System.out.println(k + " " 
								 + v.stream().map(Dish::getName).collect(Collectors.joining(",")) );
			
		});
		
		
		System.out.println("== 1 =============");
		long cnt = menu.parallelStream().count();
		System.out.println("z..Count: " + cnt);
		
	}

}
