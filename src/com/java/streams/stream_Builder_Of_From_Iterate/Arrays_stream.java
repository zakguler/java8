package com.java.streams.stream_Builder_Of_From_Iterate;

import java.util.Arrays;
import java.util.stream.Stream;

public class Arrays_stream {

	public static void main(String[] args) {

		// [Stream.empty()] build empty stream
		Stream<String> streamEmpty = Stream.empty();

		// [Stream.of()] stream of array		
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		// OR
		// [Arrays.stream()] from an array
		String[] arr = new String[]{"a", "b", "c", "d", "e"};
		String[] arr2 = {"a", "b", "c", "d", "e"};
		
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamStr = Arrays.stream(arr2);
		Stream<String> streamStr2 = Arrays.stream(new String[]{"a", "b", "c", "d", "e"});
		
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // startInclusive, endExclusive
		streamOfArrayPart.forEach(System.out::println);
	}

}
