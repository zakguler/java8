package com.java.array.arrays_asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ArraysAsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> s = new HashSet<String>();
		List<String> l = new LinkedList<>();
		
		// String [] str = {"a", "b", "c"};
		// String[] arr = new String[]{"a", "b", "c"};
		
		
		Object[] x = l.toArray(new String[0]);
		String [] str = {"a", "b", "c"};
		ListIterator<String> lit = l.listIterator();
		while (lit.hasNext()) {
			lit.next();
		}
		List<String> l2 = new ArrayList<>();
		List<String> l3 = new ArrayList<>(l2);
		l3.addAll(l2);
		
		List<Integer> l4 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
		Integer i = l4.get(2);
		
		System.out.println(i);
		
		
	}

	public boolean equals() {
		return false;
		
	}
	public int hashcode() {
		return 0;
		
	}
}
