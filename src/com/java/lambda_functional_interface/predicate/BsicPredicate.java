package com.java.lambda_functional_interface.predicate;

import java.util.function.Predicate;

// T -> boolean

public class BsicPredicate {

	public static void main(String... args) {
		
		Predicate<String> embtyStringPredicate = s -> s.isEmpty();
		
		String s1 = "";
		String s2 = "Hello..";
		
		System.out.println(embtyStringPredicate.test(s1));
		System.out.println(embtyStringPredicate.test(s2));
		
	}
}
