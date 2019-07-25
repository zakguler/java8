package com.java.streams.streamFrom;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamFromAList {

	public static void main(String[] args) {
		// ---
		Stream<String> streamEmpty = Stream.empty();

		// ---
		// Stream can also be created of any type of Collection (Collection, List, Set):
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		// OR
		List<String> l2 = Arrays.asList("a", "b", "c");
		Stream<String> streamL2 = l2.stream();

	}
}
