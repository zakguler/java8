package com.java.streams.stream_Builder_Of_From_Iterate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_infinite_limit {

	public static void main(String[] args) {

		// print 10 even numbers
		Stream.iterate(0, n -> n + 2)
		 .limit(10)
		 .forEach(System.out::println);
		
		// Java-9
		// the iterate method was enhanced with support for a predicate. 
		// For example,
		// you can generate numbers starting at 0 but stop the iteration once the number is
		// greater than 100:
		IntStream.iterate(  0				//<=== (starting, predicate, lambda function)
						  , n -> n < 100	//<=== (		  predicate, lambda function)
						  , n -> n + 4)		//<=== (					 lambda function)
					.forEach(System.out::println);

		
	}

}
