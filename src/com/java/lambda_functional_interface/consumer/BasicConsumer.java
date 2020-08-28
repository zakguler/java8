package com.java.lambda_functional_interface.consumer;

import java.util.function.Consumer;

// T - ()

public class BasicConsumer {

	public static void main(String[] args) {

		Consumer<String> printStrConsumer = s -> System.out.println(s);
		
		printStrConsumer.accept("Hi...");
		
	}

}
