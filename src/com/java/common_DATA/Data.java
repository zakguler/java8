package com.java.common_DATA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.Common_ENUM.Color;
import com.java.Common_ENUM.Sex;
import com.java.Common_MODELS.Apple;
import com.java.Common_MODELS.Dish;
import com.java.Common_MODELS.User;

public class Data {
	
	static List<Integer> numbers = Arrays.asList(3,5,8,12,20,45);
	
	static List<Apple> inventory = Arrays.asList(
	        new Apple(Color.GREEN, 80),
	        new Apple(Color.GREEN, 155),
	        new Apple(Color.RED, 120)
	    );

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
	
	
		static List<User> users = Arrays.asList(
					new User(20, "Alan",Sex.MALE),
					new User(18, "Helen",Sex.FEMALE),
					new User(45, "Joy",Sex.FEMALE),
					new User(45, "George",Sex.MALE),
					new User(25, "Jennifer",Sex.FEMALE),
					new User(11, "LittleAngle",Sex.FEMALE),
					new User(15, "Sam",Sex.MALE)
				);

	
	public static void main(String[] args) {
		
		 String [] str = {"a", "b", "c"};
		 String [] arr = new String[]{"a", "b", "c"};
		 
//		 Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
		 	List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
		 
		 
//		 Arrays.stream(new int[]{1, 2, 3, 4, 5});
		 	int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5}).min().orElse(0);
		 
		 
//		 Stream.of(1,3,7,4,6,2,9);
		 	List<Integer> numbers = (List<Integer>) Stream.of(1,3,7,4,6,2,9).filter(e -> e > 3).collect(Collectors.toSet());
		 
// 		[IntStream.of] create IntStream
			IntStream is1 = IntStream.of(4,7,9,2,55,24);
		 	
		 	
		 

	}
	
}
