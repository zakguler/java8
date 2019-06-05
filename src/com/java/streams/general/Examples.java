package com.java.streams.general;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Examples {
	public static void main(String[] args) {
		
		//---
		Stream<String> streamEmpty = Stream.empty();
		
		
		//---
		// Stream can also be created of any type of Collection (Collection, List, Set):
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		// OR
		List<String> l2 = Arrays.asList("a", "b", "c");
		Stream<String> streamL2 = l2.stream();

		
		//---
		// stream of array		
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		// OR
		String[] arr = new String[]{"a", "b", "c", "d", "e"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // stratInclusive, endExclusive
		
		streamOfArrayPart.forEach(System.out::println);
		
		

		
	}
}
