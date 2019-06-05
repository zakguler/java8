package com.java.streams.LazyStream;

import java.util.stream.Stream;

// Lazy evaluation: before the terminal operation of the pipeline is executed.
//					like print, collect, ...

// it does not matter if limit came in before the map or vice-versa

public class LazyStream {
    public static void main(String[] args) {
        Stream.iterate(0, i -> i + 1)
              .map(i -> i + 1)
              .peek(i -> System.out.println("Map: " + i))
              .limit(5)
              .forEach(i -> {});
 
        System.out.println();
        System.out.println();
 
        Stream.iterate(0, i -> i + 1)
              .limit(5)
              .map(i -> i + 1)
              .peek(i -> System.out.println("Map: " + i))
              .forEach(i -> {});
    }
}