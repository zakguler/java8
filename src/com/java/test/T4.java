package com.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.java.Common_ENUM.Color;
import com.java.Common_MODELS.Apple;

// see also, generic method below
public class T4 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(3,5,8,12,20,45);
		
		List<Apple> inventory = Arrays.asList(
		        new Apple(Color.GREEN, 80),
		        new Apple(Color.GREEN, 155),
		        new Apple(Color.RED, 120)
		    );
		
		System.out.println("===========");
		Predicate<Apple> pweight = ( (Apple a) -> a.getWeight() > 150 );
		
		List<Apple> list = filterGreenApples(inventory, pweight);
		
		
		list.forEach(e -> System.out.println(e.getColor() + " " + e.getWeight()) );
		
		//==============================
		// use lambda
		System.out.println("===========");
		
		List<Apple> list2 = filterGreenApples(inventory, ( e -> e.getWeight()>150));
		list2.forEach(e -> System.out.println(e.getColor() + " " + e.getWeight()) );
		
		//==============================
		// use generic custom class
		// call the generic method
		System.out.println("===========");
		List<Apple> list3 = filter(inventory, ( e -> e.getWeight()>150));
		list3.forEach(e -> System.out.println(e.getColor() + " " + e.getWeight()) );

		List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0); 
		evenNumbers.forEach(e -> System.out.println(e) );
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if( p.test(apple) ) {
				result.add(apple);
			}
		}
		return result;
	}
	


	
	//==============================
	//make it generic method
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T e: list){
			if( p.test(e) ) {
				result.add(e);
			}
		}
		return result;
	}

	
	
	
}


