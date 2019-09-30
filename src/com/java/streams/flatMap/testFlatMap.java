package com.java.streams.flatMap;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class testFlatMap {

	
	static List<Integer> l = Arrays.asList(1,2,3,4,5);
	
	public static void main(String[] args) {
		
		// list of the square of each number 
		List<Integer> l2 = l.stream()
							.map(i -> i*i)
							.collect(toList());
		
		l2.forEach(System.out::println);

	}

}
