package com.java.streams.streambuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream; 

public class StreamBuilderEX {
    // Driver code 
    public static void main(String[] args) 
    { 
        // Using Stream builder() 
        Stream.Builder<String> builder = Stream.builder(); 
  
        // Adding elements in the stream of Strings 
        Stream<String> stream = builder.add("Geeks") 
                                    .add("for") 
                                    .add("Geeks") 
                                    .add("GeeksQuiz") 
                                    .build(); 
  
        // Displaying the elements in the stream 
//        stream.forEach(System.out::println); <======= can't re-use the stream for the down below code
        
        //----
        System.out.println("-------");
        List<String> l = stream.map(String::toLowerCase)
        	  .collect(Collectors.toList());
        l.forEach(System.out::println);
        
        
    } 

}

