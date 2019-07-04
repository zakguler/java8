package com.java.lambda_functions.predicate;

import java.util.function.Predicate;

//passing Predicate into function 

public class PassPredicateToFunction {
	
	   static void pred(int number, Predicate<Integer> predicate) 
	    { 
	        if (predicate.test(number)) { 
	            System.out.println("Number " + number); 
	        } 
	    } 
	    public static void main(String[] args) 
	    { 
	        pred(10, (i) -> i > 7); 
	    } 

}
