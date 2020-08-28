package com.java.lambda_functional_interface.custom_functionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	String processZ(BufferedReader b) throws IOException;
}
