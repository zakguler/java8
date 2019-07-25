package com.java.streams.infiniteStream;

import java.util.stream.Stream;

public class Stream_iterate {
	
	public static void main(String[] args) {
		
		Stream.iterate(0, n -> n + 2)
		.limit(10)
		.forEach(System.out::println);
		
	}
}
