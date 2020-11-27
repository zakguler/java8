package com.java.collectionFactories_List_Set_Map_forEach;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class WorkingWith_Map_of_ofEntries_forEach_Sorted_GetOrDefault_ComputeIfAbsent_Remove_removeIf {

	/**
	 * @param args
	 */
	public static void main(String... args) {

		// Working with Map
		// Map.of()
		Map<String, Integer> ageOfFriends
		= Map.ofEntries(entry("Raphael", 30),
			 			entry("Olivia", 25),
			 			entry("Thibaut", 26));	
		System.out.println(ageOfFriends);
		
		System.out.println("==for================================================");		
		// for
		for(Map.Entry<String, Integer> entry: ageOfFriends.entrySet()) {
			String friend = entry.getKey();
			Integer age = entry.getValue();
			System.out.println(friend + " is " + age + " years old");
		}
		
		
		System.out.println("==forEach============================================");
		// forEach
//		ageOfFriends.forEach( (k,v)->{
//			System.out.print(k);
//			System.out.println(v);
//		});
		ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " +
				age + " years old"));

		
		
		System.out.println("==sorted=============================================");
		// Processes the elements of
		// the stream in alphabetic
		// order based on the
		// person’s name
		
		Map<String, String> favouriteMovies
		 = Map.ofEntries(entry("Raphael", "Star Wars"),
						 entry("Cristina", "Matrix"),
						 entry("Olivia", "James Bond"));
		
		favouriteMovies
		 .entrySet()
		 .stream()
		 .sorted(Entry.comparingByKey())
		 .forEachOrdered(System.out::println);
		
		
		System.out.println("==map..get(): getOrDefault============================");
		// 
		Map<String, String> favouriteMovies_2
		 = Map.ofEntries(entry("Raphael", "Star Wars"),
		 entry("Olivia", "James Bond"));
		
		// Outputs James Bond
		System.out.println(favouriteMovies_2.getOrDefault("Olivia", "Matrix"));
		// Outputs Matrix
		System.out.println(favouriteMovies_2.getOrDefault("Thibaut", "Matrix")); 
		
		
		System.out.println("=====================================================");
		// -computeIfAbsent—If there’s no specified value for the given key (it’s absent or its value is null), calculate a new value by using the key and add it to the Map.
		// -computeIfPresent—If the specified key is present, calculate a new value for it and add it to the Map.
		// -compute—This operation calculates a new value for a given key and stores it in the Map.		
		System.out.println("==Map..computeIfAbsent()===============");
		
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		friendsToMovies.put(
					"Sam", new ArrayList<String>(Arrays.asList("The Birds","Terminator"))
					); 
		friendsToMovies.put(
				"Alan", new ArrayList<String>(Arrays.asList("good bye, love","Jaws"))
				); 
		
		// Current style
		String friend = "Raphael";
		List<String> movies = friendsToMovies.get(friend);
		if(movies == null) {
			 movies = new ArrayList<>();
			 friendsToMovies.put(friend, movies);
		}
		movies.add("Star Wars");		
		System.out.println(friendsToMovies); 
		
		// newer using: Map..computeIfAbsent()
		friendsToMovies
			.computeIfAbsent("James", name -> new ArrayList<>())
		 	.add("Star Wars"); 
		
		System.out.println(friendsToMovies);
		
		
		System.out.println("\n==Map..computeIfPresent()===============");
		System.out.println("==see notes in the code  ===============");
		// The computeIfPresent method calculates a new value if the current value associated
		// with the key is present in the Map and non-null. Note a subtlety: if the function that
		// produces the value returns null, the current mapping is removed from the Map. If you
		// need to remove a mapping, however, an overloaded version of the remove method is
		// better suited to the task. You learn about this method in the next section.

		
		System.out.println("\n==Map..remove()==================================================");

		// current
		Map favouriteMovies_4 = new HashMap<>();
		String key = "Raphael";
		String value = "Jack Reacher 2";
		favouriteMovies_4.put(key, value);
		System.out.println(favouriteMovies_4);
		if (favouriteMovies_4.containsKey(key) &&
			Objects.equals(favouriteMovies_4.get(key), value)) {
			favouriteMovies_4.remove(key);
			 System.out.println("Current usage: Map..remove: true");
		}
		else {
			 System.out.println("Current usage: Map..remove: flase");
		}

		// newer
		favouriteMovies_4.put(key, value);
		System.out.println(favouriteMovies_4);
		favouriteMovies_4.remove(key, value);
		System.out.println("Newer usage: Map..remove: success");
		
		System.out.println("\n==Map..replaceAll()/replace()==================================================");
		
		Map<String, String> favouriteMovies_3 = new HashMap<>();
		favouriteMovies_3.put("Raphael", "Star Wars");
		favouriteMovies_3.put("Olivia", "james bond");
		System.out.println(favouriteMovies_3);
//		favouriteMovies_3.replaceAll((friend, movie) -> movie.toUpperCase());
		favouriteMovies_3.replaceAll((k, v) -> v.toUpperCase());
		System.out.println(favouriteMovies_3);
		
		
		System.out.println("\n==Map..removeIf()==================================================");
		
		// current
		Map<String, Integer> movies_2 = new HashMap<>();
		movies_2.put("JamesBond", 20);
		movies_2.put("Matrix", 15);
		movies_2.put("Harry Potter", 5);
		
		Iterator<Map.Entry<String, Integer>> iterator =
				movies_2.entrySet().iterator();
		while(iterator.hasNext()) {
		 Map.Entry<String, Integer> entry = iterator.next();
		 if(entry.getValue() < 10) {
		 iterator.remove();
		 }
		}
		System.out.println(movies_2); 
		
		// newer
		movies_2.entrySet().removeIf(entry -> entry.getValue() < 10);
		
		
		
		
	}
	

}
