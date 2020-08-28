package com.java.factory_N_Generics.generic_interface;

public interface GenericInterface<T1, T2> {
	
	T2 PerformExecution(T1 x);

	T1 ReverseExecution(T2 x);
}
