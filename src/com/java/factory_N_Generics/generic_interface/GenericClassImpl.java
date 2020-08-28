package com.java.factory_N_Generics.generic_interface;

public class GenericClassImpl implements GenericInterface<String, Integer> {
	
	public Integer PerformExecution(String x) {
		//execution code
		return null; //<== should return Integer
	}

	public String ReverseExecution(Integer x) {
		//execution code
		return null; //<== should return String
	}
}
