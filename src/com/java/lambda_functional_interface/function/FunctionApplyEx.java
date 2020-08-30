package com.java.lambda_functional_interface.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


// T -> R

public class FunctionApplyEx {

	public static void main(String[] args) {

		Function<String, Integer> lengthStr =  (String s) -> s.length();			
		System.out.println(lengthStr.apply("Hello"));		
		System.out.println("=================");
				
		//====
		List<Integer> l = zMap(Arrays.asList( "Lambdas", "in", "action"), (String s) -> s.length());
		l.forEach(System.out::println);
		
	}

	public static List<Integer> zMap(List<String> list, Function<String, Integer> f){
		List<Integer> i = new ArrayList<>();
		for (String s: list){
			i.add((Integer) f.apply(s));
		}
		return i;
	}

}
