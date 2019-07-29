package com.java.streams.J8_J9_infinite_Stream_iterate_generate;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

// Functional programming: using Predicate

public class Stream_generate {

	
	public static void main(String[] args) {
		
		// using Stream.generate() method  
	    // to generate 5 random Integer values 
	    Stream
	    	.generate(new Random()::nextInt) 
	    	// Stream.generate(new Random()::nextDouble)
	    	.limit(5)
	    	.forEach(System.out::println);
	    
	    
	    //
	    Stream<String> stream = Stream
	    							.generate(() -> Double.toString(Math.random() * 1000))
	    							.limit(10);
	    stream.forEach(System.out::println);

	    // 
	    Stream<String> stream2 = Stream.generate(() -> "test").limit(10);
	    String[] strArr = stream2.toArray(String[]::new);
	    System.out.println(Arrays.toString(strArr)); 
	    

	}	
	
	
}
