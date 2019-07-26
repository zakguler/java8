package com.java.streams.J8_J9_infiniteStream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_iterate {
	
	public static void main(String[] args) {
		
		// Java-8
		// initial starting value is: o
		// 0 to even-numbers
		Stream.iterate(0, n -> n + 2)
				.limit(10)
				.forEach(System.out::println);
		
		// Java-9
		// the iterate method was enhanced with support for a predicate. 
		// For example,
		// you can generate numbers starting at 0 but stop the iteration once the number is
		// greater than 100:
		IntStream.iterate(0, n -> n < 100, n -> n + 4)	//<=== (starting, predicate, lambda function)
					.forEach(System.out::println);
		
		
	}
}
