package com.java.streams.functional_programming.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Functional programming: using Predicate

public class TestPredicate {
	
	static List<User> users = Arrays.asList(
				new User(20, "Alan",Sex.MALE),
				new User(18, "Helen",Sex.FEMALE),
				new User(15, "Sam",Sex.MALE)
				);

	public static void main(String[] args) {
	
		List<User> people = filterUsers(users, p);
		
		//people.forEach( e -> System.out.println(e.toString()) );
		people.forEach( System.out::println );

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
	
	static Predicate<User> p = e -> e.getAge() > 10;
	
	
	
	
}
