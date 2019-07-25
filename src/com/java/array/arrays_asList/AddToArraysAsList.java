package com.java.array.arrays_asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToArraysAsList {

	public static void main(String... args) {
		
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		l.add(9);
		l.forEach(System.out::println);
		
	}
	
}
