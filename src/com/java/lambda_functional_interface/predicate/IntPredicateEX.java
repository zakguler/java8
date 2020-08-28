package com.java.lambda_functional_interface.predicate;

import java.util.function.Predicate;
import java.util.function.IntPredicate;

public class IntPredicateEX {

	public static void main(String[] args) {

		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		evenNumbers.test(1000);
		
		Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
		oddNumbers.test(1000); 
	}

}
