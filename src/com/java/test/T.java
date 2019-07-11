package com.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Employee;
import com.java.streams.collector_grouping.Department;

// Functional programming: using Predicate

public class T {

	static Predicate<User> p = e -> e.getAge() > 10;
	
	static List<User> users = Arrays.asList(
				new User(20, "Alan",Sex.MALE),
				new User(18, "Helen",Sex.FEMALE),
				new User(45, "Joy",Sex.FEMALE),
				new User(45, "George",Sex.MALE),
				new User(25, "Jennifer",Sex.FEMALE),
				new User(11, "LittleAngle",Sex.FEMALE),
				new User(15, "Sam",Sex.MALE)
				);

	
	public static void main(String[] args) {
	
		List<User> people = filterUsers(users, p);		
		//people.forEach( e -> System.out.println(e.toString()) );
		people.forEach( System.out::println );
		
		System.out.println("================================");
		System.out.println(filterUsers(users, e -> e.getAge() >11));
		
		
		System.out.println("================================");
		
		people.stream()
			.filter(e -> e.getAge() > 10)
			.map(e -> e.getName())
			.forEach(System.out::println);
		
		
		
		System.out.println("x================================");

		Map<Integer, List<User>> map = people.stream()
			.filter(e -> e.getAge() > 18)
			.collect( Collectors.groupingBy(User::getAge, Collectors.toList()) );
		
		map.forEach( (Integer k, List<User> v) -> {
		    System.out.print(k + " = ");
		    v.forEach(w -> System.out.print(w.getName() + ", "));
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
