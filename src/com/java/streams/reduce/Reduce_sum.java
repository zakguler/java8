package com.java.streams.reduce;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import com.java.Common_MODELS.Dish;
import com.java.streams.puttinItAllExample.Trader;
import com.java.streams.puttinItAllExample.Transaction;

public class Reduce_sum {

	static List<Dish> specialMenu = Arrays.asList(
			new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER));
	
	public static void main(String... args) {
		
		Optional<Integer> ds = specialMenu
				.stream()
				.map(d -> 1)
				.reduce(Integer::sum);
		
		System.out.println("# od Dishes: " + ds.get());
			
		// same as [specialMenu.stream().count()]
		System.out.println("another way: " + specialMenu.stream().count());
		
		
		//-----
		// [reduce] reduce the stream by multiplying all the elements.
		int i2 = IntStream.range(1, 5).reduce(1, (x, y) -> x * y); // > 24

		
		//-----
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);

		//----------	
		System.out.println("==================================================================================");
		System.out.println("7 What’s the highest value of all the transactions?");
		Optional<Integer> vMax = transactions.stream()
										  .map(Transaction::getValue)
										  .reduce(Integer::max);
		System.out.println(vMax.get());

		
		//----------	
		System.out.println("==================================================================================");
		System.out.println("8 Find the transaction with the smallest value.");
		Optional<Integer> vMin = transactions.stream()
				  .map(Transaction::getValue)
				  .reduce(Integer::min);
		System.out.println(vMin.get());
		//OR
		Optional<Integer> vMin2 = transactions.stream()
				  .reduce( (t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2 )
				  .map(Transaction::getValue);
		System.out.println(vMin2.get());

		
	}
	
}
