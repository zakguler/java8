package com.java.streams.collect_collectors_groupingBy_partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitioningBy_prime_nonePrime_numbers_EX {

	// 2, 3, 5, 7, 11, 13, 17, 19, 23[exclusive]
	
	public static void main(String... args) {
		Map<Boolean, List<Integer>> partitionPrime = 
			IntStream.rangeClosed(2, 22).boxed() //<=== convert IntStream to Stream
				.collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
		
		partitionPrime.forEach( (k,v) -> {
			System.out.print(k + ": ");
			System.out.println( v.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(", ")));
		});
	}
	
	
	
	public static boolean isPrime(int candidate) {
		
		// A simple optimization is to test only for factors less than or equal to the square root of
		// the candidate:
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot)
				.noneMatch(i -> candidate % i == 0);
		
//		return IntStream.range(2, candidate)
//						.noneMatch(i -> candidate % i == 0);
	}
	
}
