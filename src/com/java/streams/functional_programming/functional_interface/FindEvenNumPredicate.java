package com.java.streams.functional_programming.functional_interface;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

// Predicate: find if the number is a prime number

public class FindEvenNumPredicate {
	
	public static boolean isGreaterThan3(int num) {
		System.out.println("isGreaterThan3: " + num);
		return num > 3;
	}
	public static boolean isEven(int num) {
		System.out.println("isEven: " + num);
		return num % 2 == 0;
	}
	
	public static void main(String[] args) {
		//
		// find the double of the first even number greater than 3
		//
		
		// first EX
//		System.out.println(
//				Stream.of(5,6,3,8,7)
//				.filter(FindEvenNum::isGreaterThan3)
//				.filter(FindEvenNum::isEven)
//				.map(e -> e * 2)
//				.findFirst()
//				.get()); //<=== returns optionals object

		//-----
		// second EX: using Function[.apply()](T, Predicate)
		// uses the 'Integer as x [param value], and applies list of numbers against it
		Predicate<Integer> isGreaterThan3Too = num -> num > 3; 
		
		System.out.println(
				Stream.of(5,6,3,8,7)
				.filter(isGreaterThan3Too)
				.filter(FindEvenNumPredicate::isEven)
				.map(e -> e * 2)
				.findFirst()
				.get()); //<=== returns optionals object

		

//		//-----
//		// third EX: using Function[.apply()](T, Predicate)
//		// uses the 'Integer as x [param value], and applies list of numbers against it
//		Function<Integer, Predicate<Integer>> isGreaterThan = x -> 
//																num -> num > x; 
//		
//		System.out.println(
//				Stream.of(5,6,3,8,7)
//				.filter(isGreaterThan.apply(3))
//				.filter(FindEvenNum::isEven)
//				.map(e -> e * 2)
//				.findFirst()
//				.get()); //<=== returns optionals object
//
//		
		
	}
}
