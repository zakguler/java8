package com.java.streams.LazyStream_n_peek;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// Lazy evaluation: before the terminal operation of the pipeline is executed.
//					like before ==> print, collect, count ...

public class LazyStream {
    public static void main(String[] args) {
    	
    	// peek() is used for debugging.
    	// Using peek without any terminal 
        // operation does nothing.
    	
        
    	// EX3
        Stream.of("one", "two", "three", "four", "five", "six", "Seven")
	        .filter(e -> e.length() > 3)
	        .peek(e -> System.out.println("Filtered value: " + e))
	        .map(String::toUpperCase)
	        .peek(e -> System.out.println("Mapped value: " + e))
	        .collect(Collectors.toList())
	        .forEach(System.out::println);


        System.out.println("======");
    	// it does not matter if limit came in before the map or vice-versa
    	// EX2
        Stream.iterate(0, i -> i + 1)
              .map(i -> i + 1)
              .peek(i -> System.out.println("Map: " + i))
              .limit(5)
              .forEach(i -> {});
 
        System.out.println("======");
        
        
    	// EX3
        Stream.iterate(0, i -> i + 1)
              .limit(5)
              .map(i -> i + 1)
              .peek(i -> System.out.println("Map: " + i))
              .forEach(i -> {});
        
        
        
    }
}