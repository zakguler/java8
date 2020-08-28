package com.java.lambda_functional_interface.function;

import java.util.function.Function;

public class FunctionAndThenCompose {

	static Function<Integer, Integer> f = x -> x + 1;
	static Function<Integer, Integer> g = x -> x * 2;
	
	static Function<Integer, Integer> h = f.andThen(g);	// g(f(x))
	
	static Function<Integer, Integer> m = f.compose(g);	// f(g(x))
	
	
	public static void main(String[] args) {

		int result = h.apply(1);
		System.out.println("andThen: " + result); // 1+1 *2 = 4
		
		result = m.apply(1);
		System.out.println("compose: " + result); // 1*2 +1 = 3

	}

}
