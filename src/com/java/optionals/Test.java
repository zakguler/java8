package com.java.optionals;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5})
				  .min()
				  .orElse(0);
		System.out.println(min1);
				 
				int min2 = Arrays.stream(new int[]{})
				  .min()
				  .orElse(0);
		System.out.println(min2);
	}

}
