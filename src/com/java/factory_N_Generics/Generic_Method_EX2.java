package com.java.factory_N_Generics;

public class Generic_Method_EX2 {

	public static void main(String... args) {

	}

	public static <T> int countAllOccurrences(T[] list, T element) {
		int count = 0;
		if (element == null) {
			for (T listElement : list)
				if (listElement == null)
					count++;
		} else {
			for (T listElement : list)
				if (element.equals(listElement))
					count++;
		}
		return count;
	}
}
