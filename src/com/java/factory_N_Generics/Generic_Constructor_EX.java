package com.java.factory_N_Generics;

public class Generic_Constructor_EX<T> {

	private T length;
	private T width;
	private T height;

	// Generic constructor
	public Generic_Constructor_EX(T length, T width, T height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public static void main(String[] args) {

	}

}
