package com.java.streams.streamFrom;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOf {

	public static void main(String[] args) {

		// [Stream.empty()] build empty stream
		Stream<String> streamEmpty = Stream.empty();

		// [Stream.of()] stream of array		
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		// OR
		// [Arrays.stream()] from an array
		String[] arr = new String[]{"a", "b", "c", "d", "e"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // stratInclusive, endExclusive
		
	}

}
