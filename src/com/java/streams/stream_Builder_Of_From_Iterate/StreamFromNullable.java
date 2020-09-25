package com.java.streams.stream_Builder_Of_From_Iterate;

import java.util.stream.Stream;

public class StreamFromNullable {

	public static void main(String[] args) {

		String homeValue = System.getProperty("home");
		Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of("a","b","c");

		//OR
		
		// Using Stream.ofNullable you can rewrite this code more simply:
		Stream<String> homeValueStreamX = Stream.ofNullable(System.getProperty("home"));
	}

}
