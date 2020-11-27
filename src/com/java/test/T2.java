package com.java.test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.array.arrays_asList.ArraysStream;

public class T2 {

	// count the words in a string
	
	public static void main(String[] args) {

	  
		String str = "Hello, my name is Zak Guler. please count the number of words in my paragraph.";
		
		String[] strSplit = str.split(" ");
		
		Stream<String> strm = Arrays.stream(strSplit);
		
		List<String> l = Arrays.stream(strSplit).collect(Collectors.toList());
		l.forEach(System.out::println);
		
		
		Long cnt = strm.collect(Collectors.counting());		
		System.out.println("\n cnt: " + cnt);
		
		
		
		
		// remove commas and periods
		List<String> l2 = Arrays.stream(strSplit)
				.filter(word-> word.contains("."))	
				.collect(Collectors.toList());
		l2.forEach(w -> System.out.println("\n Words with perid: " + w));
		
		
		  
	}

}

