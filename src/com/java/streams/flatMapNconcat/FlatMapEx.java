package com.java.streams.flatMapNconcat;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;;

public class FlatMapEx {

	public static void main(String...args) {
		
//		Stream<String> combinedStream = Stream.concat(
//				  Stream.concat(collectionA.stream(), collectionB.stream()), 
//				  collectionC.stream());
		
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
