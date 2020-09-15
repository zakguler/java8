package com.java.streams.finding_matching;

import com.java.common_DATA.Data;

public class NoneMatch_RetBoolean_EX2 {

	public static void main(String[] args) {

		
		boolean notHealthy = Data.menu.stream()
				.noneMatch(dish -> dish.getCalories() >= 1000);

		if (notHealthy){
		   System.out.println("noneMatch: ALL dishes are NOT healthy...");
		}else {
			   System.out.println("noneMatch: ALL dishes are healthy...");
		}
	}

}
