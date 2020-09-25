package com.java.streams.stream_Builder_Of_From_Iterate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromAFile {

	public static void main(String[] args) {
		
//		Files.lines, which returns a stream of lines as strings from a given file. Using what
//		you’ve learned so far, you could use this method to find out the number of unique
//		words in a file
		
		long uniqueWords = 0;
		
		try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset()))
		{	// Streams are AutoCloseable so
			// there’s no need for try-finally			
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))	// generate a stream of words
								.distinct()	// Removes duplicates
								.count();	// Counts the number of unique words			
		} catch (IOException e) {
			// Deals with the exception if one
			// occurs when opening the file
		}
	}

}
