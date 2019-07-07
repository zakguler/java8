package com.java.lambda_functions;

import java.util.function.Function;

public class FunctionAndThenCompose_2 {
	

	
	public static void main(String[] args) {

		// logic anddHeader() --> andThen --> checkSpelling() --> andThen --> addFooter()
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline 
						= addHeader.andThen(Letter::checkSpelling)
									 .andThen(Letter::addFooter);
		String txt = transformationPipeline.apply("this is an example of andThen function ... labda");
		System.out.println(txt);

	}

	static class Letter {
		
		public static String addHeader(String text) {
			return "From Raoul, Mario and Alan: " + text;
		}
		
		public static String addFooter(String text) {
			return text + " Kind regards";
		}
			
		public static String checkSpelling(String text) {
			return text.replaceAll("labda", "lambda");		
		}
	}
	
}
