package com.java.lambda_functions.predicate;

import java.util.Objects;
import java.util.function.Predicate;


//Java program to illustrate AND Predicate 

public class PridecateAndNonNull {

//    public static Predicate<String> hasLengthOf10 = new Predicate<String>() { 
//        @Override
//        public boolean test(String t) 
//        { 
//            return t.length() > 10; 
//        } 
//    }; 
	public static Predicate<String> hasLengthOf10 = s -> s.length() > 10;
  
    public static void main(String[] args) 
    { 
    	predicate_and(); 
    } 
    
    
    public static void predicate_and() 
    { 
        Predicate<String> nonNullPredicate = Objects::nonNull; 
  
        String nullString = null; 
  
        boolean outcome = nonNullPredicate.test(nullString); 
        System.out.println(outcome); 

        boolean outcome2 = nonNullPredicate.and(hasLengthOf10).test(nullString); 
        System.out.println(outcome2); 
  
        String lengthGTThan10 = "Welcome to the machine"; 
        boolean outcome3 = nonNullPredicate.and(hasLengthOf10). 
        test(lengthGTThan10); 
        System.out.println(outcome3); 
    } 
}
