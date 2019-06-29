package com.java.lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.java.Common_ENUM.Color;
import com.java.Common_MODELS.Apple;

public class BehaviorParameterization {

	public static <T> List<T> filter(List<T> list, Predicate<T> p){
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
		List<Integer> numbers = Arrays.asList(3,5,8,12,20,45);
		
		// print RED apples
		List<Apple> redApples = filter(inventory, (Apple apple)-> Color.RED.equals(apple.getColor()));
		redApples.forEach(e -> System.out.println(e.getColor()));

		// print even numbers
		List<Integer> evenNumbers = filter(numbers, (Integer i) -> i%2 == 0);
		evenNumbers.forEach(i -> System.out.println(i));
	}
}
