package com.java.collections.mapList;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToObjExample {

    public static void main(String... args) {
    	
        IntStream intStream = IntStream.range(1, 5);
        Stream<BigInteger> stream = intStream.mapToObj(BigInteger::valueOf);
        stream.forEach(b -> System.out.println(b.multiply(BigInteger.TEN)));
        
        // EX_2 return other type of stream-objects
        // 		mapToObject will simply return a Stream of the type that the mapping returns.
        //Stream<Color> stream = IntStream.range(1, 5).mapToObj(i -> getColor(i));  
        
        
    }
}