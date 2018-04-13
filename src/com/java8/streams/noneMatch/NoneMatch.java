package com.java8.streams.noneMatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;

// find if the number is a prime number

public class NoneMatch {
	
	public static void main(String[] args) {
		
		System.out.println("4: " + isPrime(4)); 
		System.out.println("7: " + isPrime(7)); 
		System.out.println("8: " + isPrime(8)); 
		System.out.println("23: " + isPrime(23)); 
	}
	
	public static boolean isPrime(int number) {
		
		Predicate<Integer> isRemainderZero = diviser -> number % diviser == 0;
		
		boolean b = number > 1 && 
				IntStream.range(2, number)
				.noneMatch(index -> number % index == 0);
		
		return b;
	}
}