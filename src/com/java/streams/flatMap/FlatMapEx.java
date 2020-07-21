package com.java.streams.flatMap;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;;

public class FlatMapEx {

	public static void main(String...args) {
		
		List<String> words = Arrays.asList("Goodbye", "World");
		
		List<String> uniqueCharacters =
				words.stream()
				.map(word -> word.split(""))	// convert each word into an array of its individual letters
												// each word => String[] of letters
				.flatMap(Arrays::stream)	// flatten each generated stream into a single stream
				
				.distinct()
				.collect(toList());
	}
	
}
