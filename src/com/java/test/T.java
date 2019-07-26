package com.java.test;

import java.util.stream.Stream;

// Functional programming: using Predicate

public class T {

	
	public static void main(String[] args) {
			
			Stream.iterate(0, n -> n + n)
			.limit(20)
			.forEach(System.out::println);
			

	}	
	
	
}
