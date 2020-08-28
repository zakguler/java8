package com.java.lambda_functional_interface.consumer;

import java.util.function.Consumer;

// Consumer..accept(): (T) -> () void

public class ConsumerTestZ {
 
    public static void main(String[] args) {
 
        System.out.println("E.g. #1 - Java8 Consumer Example\n");
 
//        Consumer<String> consumerZ = ConsumerTestZ::printNames;
        Consumer<String> consumerZ = c -> ConsumerTestZ.printNames(c);
               
        consumerZ.accept("C++");
        consumerZ.accept("Java");
        consumerZ.accept("Python");
        consumerZ.accept("Ruby On Rails");
    }
 
    
    
    private static void printNames(String name) {       
        System.out.println(name);
    }
}