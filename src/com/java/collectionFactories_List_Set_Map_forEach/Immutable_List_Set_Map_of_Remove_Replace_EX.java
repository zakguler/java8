package com.java.collectionFactories_List_Set_Map_forEach;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.common_DATA.Z_Transaction;


public class Immutable_List_Set_Map_of_Remove_Replace_EX {

	public static void main(String[] args) {

		// List.of()	
		// Set.of()
		// Map.of()
		// Map.ofEntries()

		// .removeIf() <===== using Predicate
		// .replaceAll() <=== using UnaryOperator 
		
		
		
		List<String> friends = new ArrayList<>();  
		friends.add("Raphael");  
		friends.add("Olivia");  
		friends.add("Thbaut");  
 
		Set<String> friend_asList = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));

		List<String> friend_asList_2 = Arrays.asList("Raphael", "Olivia");  
		friend_asList_2.set(0, "Richard");  
//		friend_asList_2.add("Thibaut");   //<=== can NOT add

		Set<String> friend_asList_3 = Stream.of("Raphael", "Olivia", "Thibaut")  
		 .collect(Collectors.toSet());

// NEW

	// List.of()	
	// you still can NOT add elements to it.
	// can NOT update/modify
	// can NOT modify elements.  
	// does not accept null element.  

		List<String> friends_List_of = List.of("Raphael", "Olivia", "Thibaut");
		
	// Set.of()
	// can NOT contain a duplicated element.
	// can NOT add.
	// can NOT update/modify
		Set<String> friends_Set_of = Set.of("Raphael", "Olivia", "Thibaut");
		
//		Set<String> friends_Set_of_2 = Set.of("Raphael", "Olivia", "Olivia"); //<== java.lang.IllegalArgumentException: duplicate element: Olivia

		
	// Map.of()
	// Map.ofEntries()
	//	 
	// create up to 10 key/map fields
	// for more element, bigger/more elements use Map.ofEntries()
		Map<String, Integer> ageOfFriends
		 				= Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
		 		
 		//import static java.util.Map.entry;
		Map<String, Integer> ageOfFriends_2
						= Map.ofEntries(entry("Raphael", 30),
							 			entry("Olivia", 25),
							 			entry("Thibaut", 26));	
	
		
	// .removeIf() <===== using Predicate
	// .replaceAll() <=== using UnaryOperator 

	// Map.of() create up to 10 key/map fields  
	// for more element, bigger/more elements use Map.ofEntries()  
	// will mutate (changes) the same collection
	// unlike the stream, it produces a new reult (copy's it). 
		
	    List<Z_Transaction> transactions = new ArrayList<>(Arrays.asList(
	            new Z_Transaction("a12", 2011, 300),
	            new Z_Transaction("c14", 2012, 1000),
	            new Z_Transaction("b13", 2011, 400),
	            new Z_Transaction("720", 2012, 710),
	            new Z_Transaction("344", 2012, 700),
	            new Z_Transaction("983", 2012, 950)
	        ));
	    
	    // generate new copy
	    List<Z_Transaction> transactions1 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions2 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions3 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions4 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions5 = transactions.stream().collect(Collectors.toList());
	    
	    
	    
		System.out.println("Original transactions =================");
		transactions1.forEach(t -> System.out.println(t.getReferenceCode()));

		// iterator.remove():
		for (Iterator<Z_Transaction> iterator = transactions1.iterator(); iterator.hasNext(); ) 
		{
				 Z_Transaction transaction = iterator.next();
				 if(Character.isDigit(transaction.getReferenceCode().charAt(0))) {
					 iterator.remove();
				 }
		}

		System.out.println("\n transactions1 AFTER iterator.remove()=================");
		transactions1.forEach(t -> System.out.println(t.getReferenceCode()));

		
		// NEW List..removeIf() with Predicate
		
		System.out.println("\n transactions2 using removeIf()=================");
		transactions2.removeIf(transaction ->
								Character.isDigit(transaction.getReferenceCode().charAt(0)));
		
		transactions2.forEach(t -> System.out.println(t.getReferenceCode()));
		
		
		
		// current replace with stream().map()
		
		//  replace each element in a list with a new one
		System.out.println("\n transactions3 replace / uppercase with a stream =================");
		transactions3.stream()
					.map(tran -> Character.toUpperCase(tran.getReferenceCode().charAt(0)) + tran.getReferenceCode().substring(1))
					.collect(Collectors.toList())
					.forEach(System.out::println); 
		
		
		
		
		System.out.println("\n original transactions4 =================");
		transactions4.forEach(t -> System.out.println(t.getReferenceCode()));


		// current replace with iterator
		
		System.out.println("\n transactions4 replace uppercase using iterator =================");
		List<String> referenceCodes = transactions4.stream().map(t -> t.getReferenceCode()).collect(Collectors.toList());
		for (ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext(); )
		{
				 String code = iterator.next();
				 iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
		}

		referenceCodes.forEach(c-> System.out.println(c));

		
		
		System.out.println("\n original transactions5 =================");
		transactions5.forEach(t -> System.out.println(t.getReferenceCode()));

		
		
		// NEW LIST..replaceAll() with UnaryOperator
		
		System.out.println("\n transactions5 .replaceAllwith UnaryOperator =================");
		List<String> referenceCodes2 = transactions5.stream().map(t -> t.getReferenceCode()).collect(Collectors.toList());
		
		referenceCodes2.replaceAll(code -> Character.toUpperCase(code.charAt(0)) +
				code.substring(1));
		
		referenceCodes2.forEach(c-> System.out.println(c));
		
		
	}

}
