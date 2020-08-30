package com.java.lambda_functional_interface.function;

import java.util.function.Function;


// T -> R

public class BasicFunction {

	public static void main(String[] args) {

		Function<String, Integer> lengthStr =  (String s) -> s.length();	
		
		System.out.println(lengthStr.apply("Hello"));
		
		System.out.println("=================");
		
	}
}
