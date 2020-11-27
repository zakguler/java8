package com.java.functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;


// example of list.. clear(), remove(), removeAll(), replace()

public class Currying_EX {

	public static void main(String[] args) {

		List<String> l = new ArrayList<>(Arrays.asList("Sam", "Angela", "Joy"));
		
		// convert to currying:
		// CtoF(x) = x*9/5 + 32;		
		//---
		//static double converter(double x, double f, double b) {
		//	return x * f + b;
		//}
		
		//--- Currying
		// first, build function curriedConverter()
		
		// next, build multiple function(x)-in-function(f,b)
		// 2:
		DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
		DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
		DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

		// example on how to use one of the function(x)-in-function(f,b)
		// 3:
		double gbp = convertUSDtoGBP.applyAsDouble(1000);
		
		System.out.println(gbp);

	}
	
	// 1:
	static DoubleUnaryOperator curriedConverter(double f, double b){
		return (double x) -> x * f + b;
	}

}
