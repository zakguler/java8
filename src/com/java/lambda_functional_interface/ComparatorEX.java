package com.java.lambda_functional_interface;

import java.util.Comparator;

import com.java.Common_MODELS.Apple;

public class ComparatorEX {

	public static void main(String[] args) {

		//--
		Comparator<Apple> byWeight =
					(a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
		
	}

}
