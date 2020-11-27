package com.java.collections_List_Set_Map.mapToStreams;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.baeldung.com/java-maps-streams

public class MapToWorkWithStreams {

	public static void main(String[] args) {

		Map<String, String> books = new HashMap<>();
		books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-0134685991", "Effective Java");
		books.put("978-0321356680", "Effective Java: Second Edition");

		Map<String, Integer> someMap = new HashMap<>();
		
		// These each give us an entry point to process those collections by obtaining streams from them:
		// We can obtain a set of key-value pairs:
		Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
		Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();

		// We can also get the key set associated with the Map:
		Set<String> keySet = someMap.keySet();
		Stream<String> keysStream = keySet.stream();
		
		// Or we could work directly with the set of values:
		Collection<Integer> values = someMap.values();
		Stream<Integer> valuesStream = values.stream();
		
		
		//..........................................................................
		//-----------find the ISBN for the book with the title “Effective Java”.
		System.out.println("........................................................");
		
		Optional<String> isbn = books.entrySet().stream()
					.filter(e -> e.getValue().equalsIgnoreCase("Effective Java"))
					.map(Map.Entry::getKey)
					.findFirst();
		System.out.println(isbn.get());
		
		//...
		// if no book exists
		Optional<String> optionalIsbn = books.entrySet().stream()
				  .filter(e -> "Non Existent Title".equals(e.getValue()))
				  .map(Map.Entry::getKey).findFirst();
				 
				//assertEquals(false, optionalIsbn.isPresent());
		if (optionalIsbn.isPresent())
			System.out.println(optionalIsbn.get());
		else
			System.out.println("not found...");
		
		//..........................................................................
		//----------- add another book with the same title
		//----------- look for all books that start with “Effective Java”
		System.out.println("........................................................");
		
//		books.put("978-0321356680", "Effective Java: Second Edition");
		
		List<String> l = books.entrySet().stream()
				.filter(e  -> e.getValue().startsWith("Effective Java"))
				.map(e -> e.getKey())
				.collect(Collectors.toList());	
		l.forEach(System.out::println);		

		//..........................................................................
		//----------- find titles for which their ISBN start with “978-0”. 
		System.out.println("........................................................");
		List<String> l2 = books.entrySet().stream()
				.filter(e -> e.getKey().startsWith("978-0"))
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		l2.forEach(System.out::println);		
		

	
	}

}
