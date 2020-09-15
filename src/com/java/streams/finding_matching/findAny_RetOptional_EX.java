package com.java.streams.finding_matching;

import java.util.Optional;

import com.java.Common_MODELS.Dish;
import com.java.common_DATA.Data;

public class findAny_RetOptional_EX {

	public static void main(String[] args) {

		
		Optional<Dish> dish = Data.menu.stream()
				.filter(d -> d.getCalories() < 1000)
				.findAny();

		if (dish.isPresent()){
		   System.out.println("findAny: found...");
		}else {
			   System.out.println("findAny: NONE found......");
		}
		
		//=============================
		
		Data.menu.stream()
		.filter(d -> d.getCalories() < 1000)
		.findAny()
		.ifPresent(d -> System.out.println("findAny: found..." + d.getName()));
		
	}

}
