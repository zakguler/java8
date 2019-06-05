package com.java.common_DATA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.Common_ENUM.Sex;
import com.java.Common_MODELS.User;

public class Data {

//	 Arrays.asList(
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
