package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.java.Common_MODELS.Dish;
import com.java.streams.puttinItAllExample.Trader;
import com.java.streams.puttinItAllExample.Transaction;

public class Reduce_min_max {

	static List<Dish> specialMenu = Arrays.asList(
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
		
		Optional<Integer> ds = specialMenu
				.stream()
				.map(d -> 1)
				.reduce(Integer::sum);
		
		System.out.println("# od Dishes: " + ds.get());
			
		// same as [specialMenu.stream().count()]
		System.out.println("another way: " + specialMenu.stream().count());
		
		
		//-----
		// [reduce] reduce the stream by multiplying all the elements.
		int i2 = IntStream.range(1, 5).reduce(1, (x, y) -> x * y); // = 24... range 5 is exclusive

		int i3 = IntStream.range(1, 5).reduce(1, (x, y) -> x + y); // = 10... range 5 is exclusive 
		
		//-----
		Trader raoulTrader = new Trader("Raoul", "Cambridge");
		Trader marioTrader = new Trader("Mario","Milan");
		Trader alanTrader = new Trader("Alan","Cambridge");
		Trader brianTrader = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brianTrader, 2011, 300),
		new Transaction(raoulTrader, 2012, 1000),
		new Transaction(raoulTrader, 2011, 400),
		new Transaction(marioTrader, 2012, 710),
		new Transaction(marioTrader, 2012, 700),
		new Transaction(alanTrader, 2012, 950)
		);


		//----------	
		System.out.println("==================================================================================");
		System.out.println("1 find all transactions in 2011 and sort them (small to high)");
//		List<Transaction> tr2011 =
//				 transactions.stream()
//				 .filter(transaction -> transaction.getYear() == 2011) 
//		???		 .sorted(comparing(Transaction::getValue))
//				 .collect(Collectors.toList()); 
		List<Integer> tr2011 =
				 transactions.stream()
				.filter(t -> t.getYear() == 2011)					
				.map(Transaction::getValue)
				.sorted()					
				//.sorted(Comparator.reverseOrder())					
				.collect(Collectors.toList()); 
		
		System.out.println(tr2011);


		//----------	
		System.out.println("==================================================================================");
		System.out.println("2 What are the unique cities where the traders work?");
		List<String> cities =
				 transactions.stream()
				 .map(transaction -> transaction.getTrader().getCity())
				 .distinct()
				 .collect(Collectors.toList()); 
		
		System.out.println(cities);

		

		//----------	
		System.out.println("==================================================================================");
		System.out.println("3 Finds all traders from Cambridge and sort them by name");
		List<Trader> traders =
				 transactions.stream()
				 .map(Transaction::getTrader)
				 .filter(trader -> trader.getCity().equals("Cambridge"))
				 .distinct()
				 .sorted(Comparator.comparing(Trader::getName))
				 .collect(Collectors.toList()); 
		
		traders.forEach( t -> System.out.println(t.getName()) );




		//----------	
		System.out.println("==================================================================================");
		System.out.println("4 Returns a string of all traders’ names sorted alphabetically");
		String traderStr =
				 transactions.stream()
				 .map(transaction -> transaction.getTrader().getName())
				 .distinct()
				 .sorted()
				 .collect(Collectors.joining());  
		
		System.out.println(traderStr);



		//----------	
		System.out.println("==================================================================================");
		System.out.println("5 Are any traders based in Milan?");
		boolean milan =
				 transactions.stream()
				 .anyMatch(transaction -> transaction.getTrader().getName().equalsIgnoreCase("Milan"));  
		
		System.out.println(traderStr);



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
		System.out.println("***" + vMin2.get());

		
	}
	
}
