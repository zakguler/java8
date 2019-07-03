package com.java.lambda_functions.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.java.Common_ENUM.Color;
import com.java.Common_MODELS.Apple;

// Predicate..test(): (T) -> boolean

public class PassingBehaviorParameterization {

	// [functional interface - Predicate p] Passing Behavior Parameterization 
	public static <T> List<T> filterZ(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for (T e: list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	
	
	//------
	// you can use filter() with bananas, orages, integers, strings
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(
						new Apple(Color.RED, 160), 
						new Apple(Color.YELLO, 100), 
						new Apple(Color.RED, 90), 
						new Apple(Color.GREEN, 200)
						);		
//***	// print RED apples
		List<Apple> redApples = filterZ(inventory, (Apple apple)-> Color.RED.equals(apple.getColor()));
		redApples.forEach(e -> System.out.println(e.getColor()));
		System.out.println("--------");
		
		List<Integer> numbers = Arrays.asList(3,5,8,12,20,45);
//***	// print even numbers
		List<Integer> evenNumbers = filterZ(numbers, (Integer i) -> i%2 == 0);
//		evenNumbers.forEach(i -> System.out.println(i));
		evenNumbers.forEach(System.out::println);
		System.out.println("--------");
		
		List<String> stringList = Arrays.asList("Hi", "", "Sam", "Jordan", "", "US");
//***	define predicate as a variable
		Predicate<String> predicateNonEmpty = s -> !s.isEmpty();
		List<String> nonEmptyList = filterZ(stringList, predicateNonEmpty);
		nonEmptyList.forEach(System.out::println);
		System.out.println("--------");
		
		
		
		
		
	}
}
