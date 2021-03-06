package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Max_orElse {
	
	public static void main(String... args) {
		
		// given
//	    List<Integer> listOfIntegers = Arrays.asList();	// NoSuchElementException
	    List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
	    Integer expectedResult = 89;
	 
	    // then
	    Integer max = listOfIntegers
	      .stream()
	      .mapToInt(v -> v)
//	      .max();
	      .max().orElseThrow(NoSuchElementException::new);
	 
	    System.out.println("Should be 89: " + expectedResult + " = " +  max);
	    
	}
    
}
