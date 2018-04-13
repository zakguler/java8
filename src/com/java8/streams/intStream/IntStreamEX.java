package com.java8.streams.intStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntStreamEX {

	public static void main(String[] args) {

		// [IntStream.of] create IntStream
		IntStream is1 = IntStream.of(4,7,9,2,55,24);
		
		
		// [IntStream.range][IntStream.rangeClosed]
		IntStream is2 = IntStream.range(1, 3);	// > 1, 2
		IntStream is3 = IntStream.rangeClosed(1, 3);	// > 1, 2, 3
		
		// [IntStream.iterate]
		IntStream.iterate(0, i -> i + 2).limit(3);	// > 0, 2, 4
		
		
		// EXAMPLES
		IntStream.range(1, 5).map(i -> i * i); 	// > 1, 4, 9, 16
		
		
		//-----
		// gett all numbers that are divisible by 3 and 5 for a range of mim/max values
		IntStream s1 = IntStream.rangeClosed(3, 11)
							.filter(i -> (i % 3 ==0) || (i % 5 ==0)); 
//		s1.forEach(System.out::println); // print all
		
		
		//-----
		// [.boxed()] convert an IntStream to a Stream<Integer>
		Stream<Integer> s2 = IntStream.range(1, 5)
				.boxed();
		
		// convert IntStream to a List<Integer>
		List<Integer> l = s1
							.boxed()
							.collect(Collectors.toList());
		l.forEach(System.out::println); // print all
		
		// [mapToDouble]
		DoubleStream s3 = IntStream.range(1, 5).mapToDouble(i -> i);

		// [mapToLong}
		LongStream s4 = IntStream.range(1, 5).mapToLong(i -> i); 
		

		//-----
		// [anyMatch] to confirm that a certain range 
		// 				contains at least one even number.
		boolean b = IntStream.range(1, 5).anyMatch(i -> i == 2);  // > true
//		System.out.println("allMatch: " + b);
		
		// [allMatch]
		boolean b1 = IntStream.range(1, 5).allMatch(i -> i == 7);  // > false
//		System.out.println("allMatch: " + b1);
		
		// [noneMatch]
		boolean b2 = IntStream.range(1, 5).noneMatch(i -> i == 8);  // > true
//		System.out.println("noneMatch: " + b2);
		
		// confirm filtering using allMatch/noneMatch
		IntStream.range(1, 5)  
		    .filter(i -> i % 2 == 0)
		    .allMatch(i -> i % 2 == 0); // > true

		IntStream.range(1, 5)  
		    .filter(i -> i % 2 == 0)
		    .noneMatch(i -> i % 2 != 0); // > true
	
		
		//-----
		// [getAsInt] IntStream contains functions for fetching the max and min value
		IntStream.range(1, 5).max().getAsInt(); // > 4 [returns OptionalInt]
		IntStream.range(1, 5).min().getAsInt(); // > 1 [returns OptionalInt]
		
		
		//-----
		// [reduce] reduce the stream by multiplying all the elements.
		int i2 = IntStream.range(1, 5).reduce(1, (x, y) -> x * y); // > 24
		
		
		//-----
		// [parallel] parallel will execute doAnyOperation in parallel for all the elements in the stream. 
//		IntStream.range(1, 5).parallel().forEach(i -> doAnyOperation());
		
		
		
		
	}	
		
		
		
}
