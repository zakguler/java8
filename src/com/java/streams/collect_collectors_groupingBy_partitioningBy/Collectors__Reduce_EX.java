package com.java.streams.collect_collectors_groupingBy_partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.java.Common_MODELS.Dish;
import com.java.streams.puttinItAllExample.Trader;
import com.java.streams.puttinItAllExample.TransactionAllEX;

public class Collectors__Reduce_EX {

	static List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static void main(String... args) {
		
		
		
		//-----------------------------------------------
		System.out.println("== .collect(reducing(...)) ===========================");
		int totalCalories0 = menu.stream().collect(
	    		Collectors.reducing(0,			//....................... initial value
						    		Dish::getCalories,	//....................... transformation function
						    		Integer::sum));		//....................... aggregating function
		System.out.println("totalCalories0: " + totalCalories0);

		
		
		//-----------------------------------------------
		System.out.println("== .reduce(Integer::sum) ===========================");
		Optional<Integer> sumCalories = 
					menu.stream()
						.map(Dish::getCalories)
						.reduce(Integer::sum);
		System.out.println("sumCalories: " + sumCalories.get());
		
		
		
		
		//-----------------------------------------------
		System.out.println("== .mapToInt().sum() ===========================");
		int totalCalories = 
					menu.stream()
						.mapToInt(Dish::getCalories)
						.sum();
		System.out.println("totalCalories: " + totalCalories);
	
		
		
		
		//-----------------------------------------------
		System.out.println("== .reduce(Integer::sum) ===========================");
		Optional<Integer> ds = menu
				.stream()
				.map(d -> 1)
				.reduce(Integer::sum);
		
		System.out.println("# od Dishes: " + ds.get());
			
		System.out.println("== .count() ===========================");
		// same as [menu.stream().count()]
		System.out.println("another way: " + menu.stream().count());
		
		
		//-----------------------------------------------
		// [reduce] reduce the stream by multiplying all the elements.
		int i2 = IntStream.range(1, 5).reduce(1, (x, y) -> x * y); // = 24... range 5 is exclusive

		int i3 = IntStream.range(1, 5).reduce(1, (x, y) -> x + y); // = 10... range 5 is exclusive 
		
		//-----
		Trader raoulTrader = new Trader("Raoul", "Cambridge");
		Trader marioTrader = new Trader("Mario","Milan");
		Trader alanTrader = new Trader("Alan","Cambridge");
		Trader brianTrader = new Trader("Brian","Cambridge");
		
		List<TransactionAllEX> transactions = Arrays.asList(
		new TransactionAllEX(brianTrader, 2011, 300),
		new TransactionAllEX(raoulTrader, 2012, 1000),
		new TransactionAllEX(raoulTrader, 2011, 400),
		new TransactionAllEX(marioTrader, 2012, 710),
		new TransactionAllEX(marioTrader, 2012, 700),
		new TransactionAllEX(alanTrader, 2012, 950)
		);

		//----------	
		System.out.println("==================================================================================");
		System.out.println("x What’s the total value of all the transactions?");
		Optional<Integer> vSum = transactions.stream()
										  .map(TransactionAllEX::getValue)
										  .reduce(Integer::sum);
		System.out.println("z..vSum: " + vSum.get());

		

		//----------	
		System.out.println("==================================================================================");
		System.out.println("6 Prints all transactions’ values from the traders living in Cambridge");
		transactions.stream()
				 .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
				 .mapToInt(transaction -> transaction.getValue())
				 .forEach(System.out::println); 
		
//		System.out.println(traderStr);
		
		//----------	
		System.out.println("==================================================================================");
		System.out.println("7 What’s the highest value of all the transactions?");
		Optional<Integer> vMax = transactions.stream()
										  .map(TransactionAllEX::getValue)
										  .reduce(Integer::max);
		System.out.println(vMax.get());

		
		//----------	
		System.out.println("==================================================================================");
		System.out.println("8 Find the transaction with the smallest value.");
		Optional<Integer> vMin = transactions.stream()
				  .map(TransactionAllEX::getValue)
				  .reduce(Integer::min);
		System.out.println(vMin.get());
		//OR
		Optional<Integer> vMin2 = transactions.stream()
				  .reduce( (t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2 )
				  .map(TransactionAllEX::getValue);
		System.out.println("***" + vMin2.get());

		
	}
	
}
