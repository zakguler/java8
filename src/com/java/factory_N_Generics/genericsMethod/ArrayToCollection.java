package com.java.factory_N_Generics.genericsMethod;

import java.util.Collection;

public class ArrayToCollection {

	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
	    for (T o : a) {
	        c.add(o); // Correct
	    }
	}
	
	
}
