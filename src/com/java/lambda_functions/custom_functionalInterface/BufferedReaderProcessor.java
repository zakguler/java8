package com.java.lambda_functions.custom_functionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	String processZ(BufferedReader b) throws IOException;
}
