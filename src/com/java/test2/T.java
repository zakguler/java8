package com.java.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T {

	static Predicate<User> pUser = (e -> e.getAge() > 19);
	static List<User> allUsers = Arrays.asList(
					 new User("Alex", 5)
					,new User("John", 20)
					,new User("Joy", 9)
					,new User("Angela", 18)
					,new User("Tony", 35));
	
	public static void main(String[] args) {
		
		List<User> usersOver10 = findUsers(allUsers, pUser);
		usersOver10.forEach(System.out::println);
		
	}

	private static List<User> findUsers(List<User> all, Predicate<User> p) {
//		List<User> l = new ArrayList<>();
//		for (User user: all) {
//			if(p.test(user)) {
//				l.add(user);
//			}
//		}
		
		List<User> l = all.stream().filter(p).collect(Collectors.toList());
		
		return l;
	}
	
}

class User {
	private String name;
	private int age;
	
	User(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
