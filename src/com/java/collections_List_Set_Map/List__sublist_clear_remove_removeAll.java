package com.java.collections_List_Set_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// example of list.. clear(), remove(), removeAll(), replace()

public class List__sublist_clear_remove_removeAll {

	public static void main(String[] args) {

		List<String> l = new ArrayList<>(Arrays.asList("Sam", "Angela", "Joy"));
		
		//=====================
		System.out.println("------");
		List<String> l2 = l.subList(1,3); //<== (form_inclusive, to_exclusive)		
		l2.forEach(e -> System.out.println("l: " + e));
			
		//=====================
		System.out.println("------");
		l.subList(1,2).clear(); //<== (form_inclusive, to_exclusive)		
		l.forEach(e -> System.out.println("l: " + e));
			
		//=====================
		System.out.println("------");
		l.clear(); //<== (clears all elements)		
		l.forEach(e -> System.out.println("l: " + e));
	}

}
