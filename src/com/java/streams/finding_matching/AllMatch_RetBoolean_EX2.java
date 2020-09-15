package com.java.streams.finding_matching;

import com.java.common_DATA.Data;

public class AllMatch_RetBoolean_EX2 {

	public static void main(String[] args) {

		
		boolean isHealthy = Data.menu.stream()
				.allMatch(dish -> dish.getCalories() < 1000);

		if (isHealthy){
		   System.out.println("allMatch: ALL dishes are healthy...");
		}else {
			   System.out.println("allMatch: NO healthy dishes found...");
		}
	}

}
