package com.java.streams.flatMapNconcat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.Common_MODELS.Student;

public class FlatMapCombineTwoLists {

	

	
	public static void main(String... args) {
		
		List<Integer> n1 = Arrays.asList(1, 2, 3);
		List<Integer> n2 = Arrays.asList(3, 4);
		
		Integer[] a = new Integer[]{1,2,3}; 
        Integer[] b = new Integer[]{4,5,6};
        
		// combine two lists.
		// first combine two lists into a stream [using flatMap] and then collecting it into a list [Collectors.toList()].
		Stream<Integer> combinedStream = Stream.of(n1, n2)
											.flatMap(Collection::stream);
		
		Collection<Integer> collectionCombined = 
								combinedStream.collect(Collectors.toList());
		
		collectionCombined.forEach(System.out::println);
		
		System.out.println("---------------------------------------------------------");
		
		// Combine two Arrays.
		Stream<Integer> combinedStream2 = Stream.of(a, b)
											.flatMap(Stream::of);
		
		Object[] o = combinedStream2.toArray();
		System.out.println(Arrays.toString(o));
		
		System.out.println("---------------------------------------------------------");
 		Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
                list.stream()
                        .map(x -> x.getBook())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));

		System.out.println("---------------------------------------------------------");
        int[] intArray = {1, 2, 3, 4, 5, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

        intStream.forEach(x -> System.out.println(x));
	}
	
}
