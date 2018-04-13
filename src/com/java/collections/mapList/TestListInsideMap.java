package com.java.collections.mapList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

	// work with list inside a map
	// Functional programming: using Predicate
	// http://www.deadcoderising.com/2017-02-14-java-8-declarative-ways-of-modifying-a-map-using-compute-merge-and-replace/

	public class TestListInsideMap {

		static Predicate<User> p = e -> e.getAge() > 10; //<===== used as a functional programming
		
		static List<User> users = Arrays.asList(
					new User(20, "Alan",Sex.MALE),
					new User(11, "LittleAngle",Sex.FEMALE),
					new User(18, "Helen",Sex.FEMALE),
					new User(45, "Joy",Sex.OTHER),
					new User(45, "George",Sex.MALE),
					new User(25, "Jennifer",Sex.FEMALE),
					new User(15, "Sam",Sex.OTHER)
					);

		
		public static void main(String[] args) {
		
			List<User> people = filterUsers(users, p);					
			System.out.println("1================================");
			System.out.println(filterUsers(users, e -> !e.getName().isEmpty())); //<=== print all names
							
			System.out.println("2=================================");
			Map<Enum, List<User>> map = buildMapWithList(people);	//<====== Collectors.groupingBy()	
			printMapWithList(map);
			
			System.out.println("3=================================");
			// get the value from the map, sort the data, then put it back in the map.
			//		Map< Enum, List<String> > map
			map.put(Sex.FEMALE, zSortAlphabetically(map.get(Sex.FEMALE)));
			printMapWithList(map);
			
			System.out.println("4=================================");
			// Java 8, we got a new method — compute — giving us the possibility 
			// to define a function describing how we want to change the data for a given key.
			//
			map.compute(Sex.FEMALE, (key, value) -> zSortAlphabetically(value));  
			printMapWithList(map);
			
			
			System.out.println("5=================================");
			map.computeIfPresent(Sex.UNKNOWN, (key, value) -> zSortAlphabetically(value)); 
			printMapWithList(map);
			
			
			System.out.println("6=================================");
			// Add data to a map only if key isn’t there
			//		map.putIfAbsent("Java", javaArticles); 
			
			//		map.computeIfAbsent("Java", this::zHeavyOperationToFetchArticles); 
			
			System.out.println("7=================================");
			// Merging new data with existing data
			
			//		map.merge("Java", newArticles, (list1, list2) ->  
			//							  Stream.of(list1, list2)
			//							    .flatMap(Collection::stream)
			//							    .collect(Collectors.toList()));
			
			
			System.out.println("8=================================");
			// Replacing all values in a map
			
			//		map.replaceAll((key, val) -> zGetUpdatedListFor(key)); 
			
			
			
			
			
		}


//======================================================================================================================

		public static <T> List<User> zSortAlphabetically(List<User> users){			
			return users.stream().sorted().collect(Collectors.toList());
			//return users.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); //<=== reverse order
		}
		
		
		
		private static Map<Enum, List<User>> buildMapWithList(List<User> people) {
			Map<Enum, List<User>> map = people.stream()
//				.filter(e -> e.getAge() > 10)	// used earlier a Predicate to filter the elements
				.collect( Collectors.groupingBy(User::getSex, Collectors.toList()) );
			return map;
		}
		
		
		
		private static void printMapWithList(Map<Enum, List<User>> map) {
			map.forEach( (Enum k, List<User> v) -> {
				System.out.print(k + " = ");
				v.forEach(w -> System.out.print(w.getName() + "/" + w.getAge() + "/" + w.getSex() + ","));
				System.out.println();
				
			});
		}
		
		
		
		public static List<User> filterUsers(List<User> allUsers, Predicate<User> predicate) {
			List<User> result = new ArrayList<>();
			for (User user : allUsers) {
				if (predicate.test(user)) {
					result.add(user);
				}
			}
			return result;
		}	
		
		
	}
