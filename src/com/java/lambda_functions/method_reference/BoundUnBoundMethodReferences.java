package com.java.lambda_functions.method_reference;

import java.util.function.*;

public class BoundUnBoundMethodReferences {

	private final String name;

	public BoundUnBoundMethodReferences(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		BoundUnBoundMethodReferences t1 = new BoundUnBoundMethodReferences("t1");
		BoundUnBoundMethodReferences t2 = new BoundUnBoundMethodReferences("t2");

		Supplier<String> supplier = t2::methodX;
		Function<BoundUnBoundMethodReferences, String> function = BoundUnBoundMethodReferences::methodX;

		// No need to say which instance to call it on -
		// the supplier is bound to t2            
		System.out.println(supplier.get());

		// The function is unbound, so you need to specify
		// which instance to call it on
		System.out.println(function.apply(t1));
		System.out.println(function.apply(t2));
	}

	public String methodX() {
		return name;
	}
}
