package com.java.factory_N_Generics;

// type parameter is after the class name <T>
public class Generic_Class_EX<T> {
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {
		Generic_Class_EX<Integer> integerBox = new Generic_Class_EX<Integer>();
		Generic_Class_EX<String> stringBox = new Generic_Class_EX<String>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));

		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());
	}
}