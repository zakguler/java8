package com.java.lambda_functions.custom_functionalInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Predicate..processZ(): BufferedReader -> String

public class ExecuteAroundPattern {

	public static void main(String[] args) throws IOException {
		
		System.out.println(processFile( (BufferedReader br) -> br.readLine() + "\n" + br.readLine()));

	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br =new BufferedReader(new FileReader("resources/data.txt"))) {
			return p.processZ(br);
		}
	}

}
