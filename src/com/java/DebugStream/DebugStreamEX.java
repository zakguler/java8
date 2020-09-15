package com.java.DebugStream;

import java.util.List;
import java.util.stream.Collectors;

import com.java.common_DATA.Data;

public class DebugStreamEX {

	public static void main(String[] args) {

		Data data = new Data();
		List<String> nameList = data.menu.stream()
				 .filter(dish -> {
					 System.out.println("filtering: " + dish.getName());
					 return dish.getCalories() > 300;
				 	})
				 .map(dish -> {
					 System.out.println("map: " + dish.getName());
					 return dish.getName();
				 	})
				 .limit(3)
				 .collect(Collectors.toList());
		
		System.out.println(nameList);
	}

// Output:
//
//	filtering: pork
//	map: pork
//	filtering: beef
//	map: beef
//	filtering: chicken
//	map: chicken
//	[pork, beef, chicken]
//
}
