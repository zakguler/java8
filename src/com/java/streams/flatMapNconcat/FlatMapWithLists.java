package com.java.streams.flatMapNconcat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapWithLists {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);
        
        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        listOfLists.forEach(System.out::println);

             
        Stream<Integer>  StreamlistOfAllIntegers = listOfLists.stream()
                                    						  .flatMap(x -> x.stream());
   
        List<Integer> listOfAllIntegers = StreamlistOfAllIntegers.collect(Collectors.toList());
        
        listOfAllIntegers.forEach(System.out::println);
        
        
	}

}
