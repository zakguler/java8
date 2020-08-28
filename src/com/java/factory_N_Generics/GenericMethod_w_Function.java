package com.java.factory_N_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class GenericMethod_w_Function {

	public static void main(String[] args) {

			// [7, 2, 6]
			List<Integer> list = mapIt(
			 Arrays.asList("lambdas", "in", "action"),
			 (String s) -> s.length()
			 );
			
			list.forEach(System.out::println);
			
	}
	
	
	public static <T, R> List<R> mapIt(List<T> list, Function<T, R> f) {
		 List<R> result = new ArrayList<>();
		 for(T t: list) {
			 result.add(f.apply(t));
		 }
		 return result;
		}
	

}
