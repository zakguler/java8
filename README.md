# java 8,9,10,11,12 updates
-----------------------

-java 11: new synchronous HTTP client library
-Lambda: anonymous functions.
-stream: let you manipulate collections of data in a declarative way. 



---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
-java 9: Modules and reactive programming toolkit. [synchronization/parallel programming]
	-right click on the project
		-configure
			-create module-info.java
			
	-Packing a Java Module as a Standalone Application
	 You package a Java module into a standalone application using the jlink command which comes with the Java SDK. Here is how you package a Java module with jlink :
		c:\>jlink

	-exports com.java.collections.mapList;
	
	
	
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
Functional Interfaces

you can use lambda expression in the context of a Functional Interface 
								[ contains ONLY one abstract method].
								[ there is one exception to the rule that only one abstract method is allowed - 
								[ a functional interface can have another abstract methods if they are implemented by java.lang.Object, 
								[ for example toString().]

-(parameters) -> expression
-(parameters) -> {statements; }


Package java.util.function

	T: Object of generic type -first argument
	U: type -second argument
	L: ???
	R: Object of generic type return/result
	boolean: true/false


	Function								 Functional descriptor
	--------								 ----------------------
	Comparator..compare()................... (T, T) -> R.... personList.sort( (Person p1, Person p2)  ->  p1.getSurName().compareTo(p2.getSurName()) );
	Comparator..comparing()................. Comparator<Apple> c = Comparator.comparing(Apple::getWeight());
	Comparable..compareTo().................


	Predicate.
		.test()............................. T -> boolean... List<String> strString = filter( listOfStrings, (String s) -> s.!s.isEmpty() );
		.isEqual()
		.and().............................. boolean outcome2 = nonNullPredicate.and(hasLengthOf10).test(nullString);
		.negate()
		.or()
		-----so, a.or(b).and(c)	must be read as: (a || b) && c
		-----    a.and(b).or(c) must be read as: (a && b) || c	
		
	IntPredicate..test(int i)............... int -> int..... IntPredicate evenNumbers = (int i) -> i % 2 == 0;
	DoublePredicate
	BiPredicate............................. (L, R) -> boolean
	
	
	Consumer..accept()...................... T -> void...... forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i) );
	IntConsumer
	BiConsumer..							(T, U) -> void
	
	Function..apply()....................... T -> R......... List<Integer> l = map(Array.asList( "Lambdas", "in", "action"), (String s) -> s.legth()) );
			 .andThen()..................... f.andThen(g) ===> g(f(x))
			 .compose()..................... f.compose(g) ===> f(g(x))
	IntFunction
	ToIntFunction							 T -> int
	IntToDoubleFunction
	BiFunction..apply().....................(T, U) -> R....................... (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight())
	ToIntBiFunction<T,T>....................(T,T) -> int
	
	
	Supplier..get()							() -> T......... () -> new Apple(10)  //it takes one argument and returns a result
	
	BinaryOperator..						(T, T) -> T
	IntBinaryOperator..						(int, int) -> int................. (int a, int b) -> A * b
	LongBinaryOperator
	
	UnaryOperator..							T -> T


---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
>http://www.baeldung.com/java-8-double-colon-operator

>[method reference] double colon '::' 
	
	[Bound][t2]........................ Supplier<String> supplier = t2::method;
	[UnBound][class/instance name]..... Function<Test, String> function = Test::method;
	
	EX with [lambda] 
			inventory.sort( (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) );
			
	   with [method reference]		
			inventory.sort(comparing(Apple::getWeight)); 
			inventory.sort(comparing(Apple::getWeight)reversed()); 


    Lambda Method                                       reference equivalent    
    (Apple a) -> a.getWeight() ........................ Apple::getWeight
    () -> Thread.currentThread().dumpStack() .......... Thread.currentThread()::dumpStack
    (str, i) -> str.substring(i) ...................... String::substring
    (String s) -> System.out.println(s) ............... System.out::println  
    (String s) -> this.isValidName(s).................. this::isValidName
           

	[static method].................................... Integer::parseInt
	[instance method].................................. String::length
	[local method] Transaction expensiveTransaction.... expensiveTransaction::getValue 
	[constructors reference][with 0 arguments]................... [new Apple()]=========>	Supplier<Apple> s = Apple::new; Apple a1 = s.get();
	[constructors reference][with 1 arguments]................... [new Apple(weight)]===>	Function<Integer, Apple> s = Apple::new; Apple a1 = s.get(110);
	[constructors reference][with 2 arguments]................... [new Apple(color, weight)]===>	BiFunction<Color, Integer, Apple> s = Apple::new; Apple a1 = s.get(GREEN, 110);
	[constructors reference][with 3 arguments]................... create your own CustomTriFunction<T, U, V, R>... see example below
	[array constructors] ???
	[super calls] ???
	
	
	
	
	EX:
		[constructors reference][with 3 arguments]................... create your own CustomTriFunction<T, U, V, R>
			public interface CustomTriFunction<T, U, V, R> {
				R apply(T t, U u, V v);
			}
			..
			CustomTriFunction<Integer, Integer, Integer, RGB> colorFactory = RGB::new;
			
	EX: expensiveTransaction = new Transaction();
		expensiveTransaction::getValue;	<====================== () -> expensiveTransaction.getValue();
	
	

>https://stackoverflow.com/questions/35914775/java-8-difference-between-method-reference-bound-receiver-and-unbound-receiver
>Java 8: Difference between method reference Bound Receiver and UnBound Receiver

		EX1
		The idea of unBound receiver such as String::length is that you’re referring to a method to 
		an object that will be supplied as one of the parameters of the lambda. 
		For example, the lambda expression (String s) -> s.toUpperCase() can be rewritten as String::toUpperCase.

		But Bounded refers to a situation when you’re calling a method in a lambda to an external object 
		that already exists. 
		For example, the lambda expression () -> expensiveTransaction.getValue() 
		can be rewritten as expensiveTransaction::getValue.

		Situations for three different ways of method reference
		basic rules:
			(args) -> ClassName.staticMethod(args) can be ClassName::staticMethod
	
			(arg0, rest) -> arg0.instanceMethod(rest) can be ClassName::instanceMethod (arg0 is of type  ClassName)
	
			(args) -> expr.instanceMethod(args) can be expr::instanceMethod

		Answer retired from Java 8 in Action book


		----
		EX2
		Basically, unbound receivers allow you to use instance methods as 
		if they were static methods with a first parameter of the declaring type - so 
		you can use them as functions by passing in whatever instance you want. 
		With a bound receiver, the "target" instance is effectively part of the 
		function.

		An example might make this clearer:

		import java.util.function.*;

		public class Test {

			private final String name;

			public Test(String name) {
				this.name = name;
			}

			public static void main(String[] args) {
				Test t1 = new Test("t1");
				Test t2 = new Test("t2");

				Supplier<String> supplier = t2::method;
				Function<Test, String> function = Test::method;

				// No need to say which instance to call it on -
				// the supplier is bound to t2            
				System.out.println(supplier.get());

				// The function is unbound, so you need to specify
				// which instance to call it on
				System.out.println(function.apply(t1));
				System.out.println(function.apply(t2));
			}

			public String method() {
				return name;
			}



---------------------------
---------------------------

-Stream.concat( Stream(a), Stream(b) )	// also you can use flatMap(): search for an example..
-Stream.of(l1, l2)
-Stream.of(n1, n2).flatMap(Collection::stream);
	
-Arrays.asList("a", "b", "c");
-static List<Dish> specialMenu = Arrays.asList( new Dish("seasonal fruit", true, 120, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH));
-Stream<String> streamOfWords = Arrays.stream( {"GoodBye", "World"} );


-Building streams [summary]:
	
	[Stream.of()]=============================== Stream<String> s = Stream.of("Modern ", "Java ", "In ", "Action");
	[Stream.empty()]============================ Stream<String> emptyStream = Stream.empty();	// get an empty stream
	[Stream.ofNullable()]======[Java9]========== Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));
	[Arrays.stream()]=========================== int sum = Arrays.stream( {2, 3, 5, 7, 11, 13} ).sum();
	[l2.stream()][from a List]================== List<String> l2 = Arrays.asList("a", "b", "c"); Stream<String> streamL2 = l2.stream();
	[coll.stream()][from a Collection]========== Collection<String> collection = Arrays.asList("a", "b", "c"); Stream<String> streamOfCollection = collection.stream();
	[from a file]=============================== try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {....}
	
	[map.entrySet().stream()][from a map]======= Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
												 Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();
	
	[map.keySet().stream][from a map..key]====== Set<String> keySet = someMap.keySet();
												 Stream<String> keysStream = keySet.stream();
					
	[map.values().stream][from a map..value]==== Collection<Integer> values = someMap.values();
												 Stream<Integer> valuesStream = values.stream();
												 
	[Stream.iterate(x,y)] [infinite stream]===== Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
	
	[j9][IntStream.iterate(x,y,z)]============== IntStream.iterate(0, n -> n < 100, n -> n + 4)	//<=== (starting, predicate, lambda function)
														  .forEach(System.out::println);
	[Stream.generate()] [infinite stream]======= Stream.generate(() -> Double.toString(Math.random() * 1000)).limit(10);
	

.stream()
.parallelStream()

	-stream pipeline is similar to the [builder pattern] [chain of calls]
	
	-generating a stream from an ordered collection preserves the ordering.

	-Stateless vs stateful
			stateless:
				.map
				.filter
				..
				
			stateful:
				.reduce		[bounded]
				.sorted		[unbounded]
				.distict 	[unbounded]
				.skip 		[bounded]
				.limit		[bounded]
				..
				
				
	-intermediate and terminal operations
	
	-[lazy] intermediate operations: <====== return another stream 
		xyz.stream()
			.filter [T -> boolean]
			.sorted [(T, T) -> int]
			.distinct [lazy]???
						
			.map() [short-circuiting] [T -> R] <==== function to create a new version of... [NOT modifying]
			.map()	<======================= you can use multiple map(s), filter(s) ..
			.mapToInt()
			.mapToLong()
			.mapToDouble()
			.flatmap <====================== combine multiple maps into one Stream<string[]>'s to Stream<String>
			.flatMapToInt
			.flatMapToLong
			.flatMapToDouble
			.concat(Stream<? extends T> a, Stream<? extends T> b)()
			
			.limit()
			.skip()	<======================= discards the first (n) elements.
			.build()
			.sorted

			[Java9]
			.takeWhile <==================== [must be a sorted list] +stops once an element found >= 320
			.dropWhile <==================== [must be a sorted list] +stops once an element found > 320
			
			
	-terminal operations:	<=============== result in any non-stream value [ex: list, Integer, void...]
			import static java.util.stream.Collectors.*;
			.collect
				(Collectors.toList()
				(Collectors.toSet()
				(Collectors.counting()
				(Collectors.maxBy(Comparator<T>)
				(Collectors.minBy(Comparator<T>)
				(Collectors.summingInt()
				(Collectors.joining(",")
				(Collectors.reducing(x,y,z)
				(Collectors.groupingBy(Person::getCity)
				(Collectors.groupingBy(..lambda..)
				
				(Collectors.groupingBy(Dish::getType,
						  				Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())
						  			  ));
				(Collectors.groupingBy(Dish::getType,
						   				Collectors .flatMapping(dish -> dishTags.get( dish.getName() ) .stream(), Collectors.toSet())));		  			  
					
			.forEach
			.count
			.allMatch
			.anyMatch
			.noneMatch
			.reduce	<======================= a stream is reduced to a value
			
			.findFirst()
			.findAny()
			.findEach()			
			
	---------------------------------- 	
	---------------------------------- 	
	[.distinct]
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
				.filter(i -> i % 2 == 0)
				.distinct()
				.forEach(System.out::println);
 	
 	slicing 
 	[.takeWhile]
 			import static java.util.stream.Collectors.*;
			List<Dish> filteredMenu = specialMenu
				.stream()
				.takeWhile(dish -> dish.getCalories() < 320) // [must be a sorted list] +stops once a dish found >= 320
				.collect(toList());
		
	 		
	[filter]
	[limit] 	
			import static java.util.stream.Collectors.*;	
	 		List<Dish> dishes = menu
	 			.stream()
				.filter(dish -> dish.getType() == Dish.Type.MEAT)
				.limit(2)
				.collect(toList());


	[map]
	[mapToInt]
	[mapToDouble]
	[mapToLong]
	
			.map(Transaction::getValue);
			..
			
			int calories = menu.stream()
								.mapToInt(Dish::getCalories)
								.sum();
			..
			
	
	[OptionalInt]
	[OptionalDouble]
	[OptionalLong]
		.get()
		.orElse()
		.orElseGet()
	
			OptionalInt maxCalories = menu.stream()
											.mapToInt(Dish::getCalories)
											.max();
			int max = maxCalories.orElse(1);	<============================= // if no elements, set default value to 1
			


	[IntStream]
	[DoubleStream]
	[LongStream]
		
			-supports: .sum .min .max .average  .rang .rangClosed
				
			IntStream intStream = IntStream.range(1, 100);			// exclusive [1-99] [100 not included]
			IntStream intStream = IntStream.rangeClosed(1, 100)		// inclusive [1-100][100 is included]
										   .filter(n -> n%2 == 0);
			
			
			// converting back to a stream of Objects [int -> Integer]
			IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
			Stream<Integer> stream = intStream.boxed();
	
	
			
			
	[flatmap]
	[flatMapToInt]	
	
			Stream can hold different data types, But, the Stream operations (filter, sum, distinct…) and collectors do not support it, 
			so, we need flatMap() to do the following conversion :
			
				Stream<String[]>		-> flatMap ->	Stream<String>
				Stream<Set<String>>		-> flatMap ->	Stream<String>
				Stream<List<String>>	-> flatMap ->	Stream<String>
				Stream<List<Object>>	-> flatMap ->	Stream<Object>
			
			How flatMap() works :
				{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
				{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
			
			EX:
			import static java.util.stream.Collectors.*;
			
			List<String> words = Arrays.asList("Goodbye", "World");	
			List<String> uniqueCharacters = words
				.stream()
				.map(word -> word.split(""))	// convert each word into an array of its individual letters
												// each word => String[] of letters
				.flatMap(Arrays::stream)		// flatten each generated stream into a single stream				
				.distinct()
				.collect(toList());
			
			EX:
			// combine two lists.
			// first combine two lists into a stream [using flatMap] and then collecting it into a list [Collectors.toList()].
			Stream<String> combinedStream = Stream.of(collectionA, collectionB)
			  										.flatMap(Collection::stream);
			Collection<String> collectionCombined = 
			  combinedStream.collect(Collectors.toList());
								
								
	 		EX: // Stream<List<String>>	-> flatMap ->	Stream<String>
	 		import static java.util.stream.Collectors.*;
	 		public class Student {
			    private String name;
			    private Set<String> book;
			
			    public void addBook(String book) {
			        if (this.book == null) {
			            this.book = new HashSet<>();
			        }
			        this.book.add(book);
			    }
			    //getters and setters
			    // getBook()			
			}
			--- main()
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
			
			//import static java.util.stream.Collectors.*;
	        List<String> collect =
	                list.stream()
	                        .map(x -> x.getBook())      //Stream<Set<String>>
	                        .flatMap(x -> x.stream())   //Stream<String>
	                        .distinct()
	                        .collect(Collectors.toList());
	
	        collect.forEach(x -> System.out.println(x));
	 		
	 		EX:
	 		int[] intArray = {1, 2, 3, 4, 5, 6};
	        //1. Stream<int[]>
	        Stream<int[]> streamArray = Stream.of(intArray);	
	        //2. Stream<int[]> -> flatMap -> IntStream
	        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));	
	        intStream.forEach(x -> System.out.println(x));
	 		
	 		
	 		EX:
	 		List<String> betterLetters = Stream.of(l1, l2)
				.flatMap(List::stream)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	 		
	 		
	[concat]
			// combine two lists
			Stream<String> combinedStream = Stream.concat(
												  collectionA.stream(),
												  collectionB.stream()
												  );
			// combine multiple lists									  
			Stream<String> combinedStream = Stream.concat(
												  Stream.concat(collectionA.stream(), collectionB.stream()), 
												  collectionC.stream()
												  );
	
														   		
			
	[anyMatch]..
	[allMatch]..
	[nonMatch].. returns boolean
			if(menu.stream().anyMatch(Dish::isVegetarian)) {
				System.out.println("The menu is (somewhat) vegetarian friendly!!");
			}
			..
			boolean isHealthy = menu.stream()
									.allMatch(dish -> dish.getCalories() < 1000);
			..
			boolean isHealthy = menu.stream()
									.noneMatch(d -> d.getCalories() >= 1000);
			
			
	[findAny]... returns Optional
			Optional<Dish> dish =
					menu.stream()
					.filter(Dish::isVegetarian)
					.findAny();

			OR
			menu.stream()
				.filter(Dish::isVegetarian)
				.findAny()	//<======================================== returns Optional<Dish>
				.ifPresent(dish -> System.out.println(dish.getName());

	[findFirst]
			// for example, the code that follows, given a list of numbers, 
			// finds the first square that’s divisible by 3):
			// Returns an Optional<Dish>. If a value is contained,
			// it’s printed; otherwise
			// nothing happens.
			
				List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
				Optional<Integer> firstSquareDivisibleByThree =
						someNumbers.stream()
									.map(n -> n * n)
									.filter(n -> n % 3

	[reduce]
		[Integer::sum]
		[Integer::max]
		[Integer::min]
		
			// a stream is reduced to a value
			EX: sum all elements and preduce a new value
				0: is the initial value
				(a, b) -> a + b : BinaryOperator<T> to combine two elements
			int sum = numbers.stream().reduce(0, (a, b) -> a + b);
			{4,5,3,9}==21
			
			OR 
			int sum = numbers.stream().reduce(0, Integer::sum);
			
			OR
			// NO INITIAL VALUE, will return Optional<Integer>
			Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b));
			..	
			
			EX: multiply all elements
			int product = numbers.stream().reduce(1, (a, b) -> a * b);
			.
			
			Optional<Integer> max = numbers.stream().reduce(Integer::max);
			..
			
			Optional<Integer> min = numbers.stream().reduce(Integer::min);
			OR
			Optional<Integer> min = numbers.stream().reduce((x, y) -> x < y ? x : y);
			..				
			
			
	[sorted]
			transactions.stream()
					.filter(t -> t.getYear() == 2011)
					.sorted(comparing(Transaction::getValue))
					.forEach(System.out::println);	
					
					
		
	[collect()]	
		import java.util.stream.Collectors;
		
		[Collectors.toList()]
			List<Transaction> transactions = transactionStream
												.collect(Collectors.toList());
		
		[Collectors.counting()]		
			long howManyDishes = menu.stream().collect(Collectors.counting());	// menu.stream().count();								
	
		[Collectors.maxBy()]
		[Collectors.minBy()]
			Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
			Optional<Dish> mostCalorieDish = menu.stream()
												 .collect(maxBy(dishCaloriesComparator));

			
		[Collectors.summingInt()]
		[Collectors.summingDouble()]
		[collecters.averagingInt()]
		[collecters.averagingLong()]
		[collecters.averagingDouble()]
		[collecters.summarizingInt()]
			int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
			double totalCalories = menu.stream().collect(summingDouble(Dish::getCalories));
			double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
			IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
			LongSummaryStatistics..
			DoubleSummaryStatistics..
			
		[collecters.joining()]	... default 'space'
		[collecters.joining(", ")]
			String shortMenu = menu.stream().map(Dish::getName).collect(joining());
	    	String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));
		
		
		[collecters.reducing(x,y,z)]
			int totalCalories0 = menu.stream().collect(
	    		reducing(0,			//....................... initial value
	    		Dish::getCalories,	//....................... transformation function
	    		Integer::sum));		//....................... aggregating function
			
			int totalCalories2 = menu.stream().collect(reducing( 0, Dish::getCalories, (i, j) -> i + j) );
			Optional<Dish> mostCalorieDish2 = menu.stream().collect(reducing( (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2) );
			
			
		[(Collectors.groupingBy()]
		[groupingByConcurrent()] same as above
		
			[Map] [:: method reference]
					Map<Dish.Type, List<Dish>> dishesByType =
							menu.stream().collect(groupingBy(Dish::getType));

			[Map] [..lambda..]
					public enum CaloricLevel { DIET, NORMAL, FAT };
					Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = 
						menu.stream().collect( groupingBy(dish -> {
															if (dish.getCalories() <= 400) return CaloricLevel.DIET;
															else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
																else return CaloricLevel.FAT;
																	} 
														 )
											 );

			[Map] toList
					Map<Department,List<Employee>> employeeMap = 
						employeeList.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment));
						System.out.println("Employees grouped by department");
						employeeMap.forEach((Department key, List<Employee> empList) -> System.out.println(key +" -> "+empList));					
					}

			[Map] toSet
					Map<Department,Set<Employee>> employeeMap2 = 
							employeeList.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
					System.out.println("Employees grouped by department");
					employeeMap2.forEach((Department key, Set<Employee> empSet) -> System.out.println(key +" -> "+empSet));


			[Map] [new TreeMap type]  toSet			
					Map<Department,Set<Employee>> employeeMap5
							= employeeList.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.toSet()));
						  employeeMap5.forEach((Department key, Set<Employee> empSet) -> System.out.println(key +" -> "+empSet));

			[Map] filtering... toList		  
					Map<Dish.Type, List<Dish>> caloricDishesByType2 =
						  menu.stream()
						  	  .collect(Collectors.groupingBy(Dish::getType,
						  			   Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())
						  			  ));
						 
						 
						 		

---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
[switch] with [lambda] expression:
[Java 12]

	enum Day {
        MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	public static String getDay (Day today) {
        return switch(today) {
               case MON, TUE  -> "Blues";
		       case WED       -> "Hectic";
		       case THUR, FRI -> "Getting Better";
		       default        -> "Life!";
        };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDay(Day.TUE));
	}


---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
Target type
	-Predicate<List<String>>.......	Target type is:	<List<String>>
	-Consumer<Apple>............... Target type is:	<Apple>	
	

-----	
Cast expression

	Object o = () -> {System.out.println("example"); };	<=== won't compile
	
	Object o = (Runnable) () -> {System.out.println("example"); };	<=== won't compile
			T-> void
			
	OR
		Runnable r = () -> {System.out.println("example"); };	<=== won't compile

---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
ActionListener..actionPerformed()....... jpfPassword.addActionListener(e -> nOKButton.doClick());
EventHandle..handle()................... button.setOnAction( (ActionEvent event) -> lable.setText("Sent!!") );

PrivilegedAction..run()................. () -> T........ PrivilegedAction<Integer> p = () -> 42;
Callable..call()........................ () -> T........ Callable<Integer> p = () -> 42;

Runnable..run()......................... () -> void..... Thread t = new Thread( () -> System.out.println("Hello World") ); t.start();
														 // Runnable task = () -> {
															    String threadName = Thread.currentThread().getName();
															    System.out.println("Hello " + threadName);
															};														
															task.run();
															
															Thread thread = new Thread(task);
															thread.start();



---------------------------
---------------------------
// Split up the array of whole names into an array of first/last names
import static java.util.stream.Collectors.*;
List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
		.map(name -> name.split(" "))
		.collect(Collectors.toList());

// Use a Java 8 stream to print out each tuple of the list
splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

// Use a Java 8 stream to print out each tuple of the list
splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));



log.info("Querying for customer records where first_name = 'Josh':");

jdbcTemplate.query(
		"SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
		
		(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		
		).forEach(customer -> log.info(customer.toString()));




----
quotes.getQuotes()
		.stream()
		.forEach( quote -> {
			quoteRepository.save(new Quote(id, name, "this is a quote"));		
		});

OR

quotes.getQuotes()
		.stream()
		.map(quote -> new Quote(quote.getId, quote.getName, "this is a quote"))
		.forEach( quote -> {
			quoteRepository.save(quote);		
		});
		
		
----		
Topic topic = topics.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();
		
		
==================================================================================================		
[sort]  inventory.sort(comparing(Apple::getWeight));
		inventory.sort(comparing(Apple::getWeight).reversed()); 
		
		inventory.sort(comparing(Apple::getWeight) 			// sort by decreasing weight
						.reversed()
						.thenComparing(Apple::getCountry)); // sort further by country when apples have the same weight.
		

		personList.sort( (Person p1, Person p2)  ->  p1.getSurName().compareTo(p2.getSurName()) );
		inventory.sort( (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight()) );
		strList.sort((s1, s2) -> s1.compareToIgnoreCase(s2) );	
		strList.sort( String::compareToIgnoreCase );
		
		
==================================================================================================		
[map]<list>
[map.compute()]
[map.computeIfPresent()]
[map.computeIfAbsent()]
[map.putIfAbsent()]
[map.put()]
[map.merge()]
[map.replaceAll()]
[map.entrySet().stream()]


		[sort] the list	
					System.out.println("3=================================");
					// get the value from the map, sort the data, then put it back in the map.
					//		Map< Enum, List<String> > map
					map.put(Sex.FEMALE, zSortAlphabetically(map.get(Sex.FEMALE)));
					printMapWithList(map);
					
					System.out.println("4=================================");
					// Java 8, we got a new method — compute — giving us the possibility 
					// to define a function describing how we want to change the data for a given key.
					//
					map.compute(Sex.FEMALE, (key, value) -> zSortAlphabetically(value));  
					printMapWithList(map);
					
					
					System.out.println("5=================================");
					map.computeIfPresent(Sex.UNKNOWN, (key, value) -> zSortAlphabetically(value)); 
					printMapWithList(map);

					System.out.println("6=================================");
					// Add data to a map only if key isn’t there
					//		map.putIfAbsent("Java", javaArticles); 
					
					//		map.computeIfAbsent("Java", this::zHeavyOperationToFetchArticles); 
					
					System.out.println("7=================================");
					// Merging new data with existing data
					
					//		map.merge("Java", newArticles, (list1, list2) ->  
					//							  Stream.of(list1, list2)
					//							    .flatMap(Collection::stream)
					//							    .collect(Collectors.toList()));

					
					System.out.println("8=================================");
					// Replacing all values in a map
					
					//		map.replaceAll((key, val) -> zGetUpdatedListFor(key)); 


					System.out.println("8=================================");
					[map.entrySet().stream()]
					
					Map<String, String> books = new HashMap<>();
					books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
					books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
					books.put("978-0134685991", "Effective Java");
					books.put("978-0321356680", "Effective Java: Second Edition");
			
					Map<String, Integer> someMap = new HashMap<>();
					
					// These each give us an entry point to process those collections by obtaining streams from them:
					// We can obtain a set of key-value pairs:
					Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
					Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();
			
					// We can also get the key set associated with the Map:
					Set<String> keySet = someMap.keySet();
					Stream<String> keysStream = keySet.stream();
					
					// Or we could work directly with the set of values:
					Collection<Integer> values = someMap.values();
					Stream<Integer> valuesStream = values.stream();
					
					
					//..........................................................................
					//-----------find the ISBN for the book with the title “Effective Java”.
					System.out.println("........................................................");
					
					Optional<String> isbn = books.entrySet().stream()
								.filter(e -> e.getValue().equalsIgnoreCase("Effective Java"))
								.map(Map.Entry::getKey)
								.findFirst();
					System.out.println(isbn.get());
					
					//...
					// if no book exists
					Optional<String> optionalIsbn = books.entrySet().stream()
							  .filter(e -> "Non Existent Title".equals(e.getValue()))
							  .map(Map.Entry::getKey).findFirst();
							 
							//assertEquals(false, optionalIsbn.isPresent());
					if (optionalIsbn.isPresent())
						System.out.println(optionalIsbn.get());
					else
						System.out.println("not found...");
					
					//..........................................................................
					//----------- add another book with the same title
					//----------- look for all books that start with “Effective Java”
					System.out.println("........................................................");
					
			//		books.put("978-0321356680", "Effective Java: Second Edition");
					
					List<String> l = books.entrySet().stream()
							.filter(e  -> e.getValue().startsWith("Effective Java"))
							.map(e -> e.getKey())
							.collect(Collectors.toList());	
					l.forEach(System.out::println);		
			
					//..........................................................................
					//----------- find titles for which their ISBN start with “978-0”. 
					System.out.println("........................................................");
					List<String> l2 = books.entrySet().stream()
							.filter(e -> e.getKey().startsWith("978-0"))
							.map(e -> e.getValue())
							.collect(Collectors.toList());
					l2.forEach(System.out::println);		
					

					
			
==================================================================================================
			
==================================================================================================
[List][list.removeIf(true/false predicate)]

	public void updateTopic(String id, Topic topic) {
		Topic t = topics.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();
		topics.set(topics.indexOf(t), topic);	
	}

	public void deleteTopic(String id) {
		topics.removeIf(e-> e.getId().equalsIgnoreCase(id));		
	}



==================================================================================================

==================================================================================================
>http://www.baeldung.com/java-nashorn
>Introduction to Nashorn -JavaScript engine for JAVA8

		This article is focused on Nashorn – the new default JavaScript engine for the JVM as of Java 8.

		What is jjs?
			In Java 8, jjs is the new executable or command line tool used to execute Javascript code at the console.

	
			

==================================================================================================
>[optionals]

	menu.stream()
		.filter(Dish::isVegetarian)
		.findAny() //<========================================== returns Optional<Dish>
		.ifPresent(dish -> System.out.println(dish.getName());

	[.isPresent()]
	[.ifPresent(execute this block if true)]
	[.get()]
	[.orElse()]
	


==================================================================================================
[Arrays..stream]
[.min]
[.orElse]
	import java.util.Arrays;

	public class Test {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5})
					  .min()
					  .orElse(0);
			System.out.println(min1);
					 
					int min2 = Arrays.stream(new int[]{})
					  .min()
					  .orElse(0);
			System.out.println(min2);
		}

	}

	
	
==================================================================================================



>http://www.baeldung.com/java-8-interview-questions
	
	Describe some of the functional interfaces in the standard library.

		There are a lot of functional interfaces in the java.util.function package, the more common ones include but not limited to:

		Function – it takes one argument and returns a result
		Consumer – it takes one argument and returns no result (represents a side effect)
		Supplier – it takes one argument and returns a result
		Predicate – it takes one argument and returns a boolean
		BiFunction – it takes two arguments and returns a result
		BinaryOperator – it is similar to a BiFunction, taking two arguments and returning a result. The two arguments and the result are all of the same types
		UnaryOperator – it is similar to a Function, taking two arguments and returning a result. The argument and the result are all of the same types
	
	

============================================================================================
============================================================================================
============================================================================================

-[anonymous functions] [lambda] functional programming.
-[Predicate<T>] []Functional Interface]: This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
-[::] [method reference].

-[behavior parameterization] page 28 [java8 in action].
-[streams] collections-like API.
-[streams] for-each loop is called External Iteration.
-[streams] strema API called Internal Iteration.
-[streams] forking step [run in parallel].
-[null pointer exception] use "Optional<T>()" to help avoid null pointer exception.




============================================================================================
============================================================================================
============================================================================================

---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------

EX_1:	String twoLines = processFile( (BufferedReader br) -> br.readline() + br.readline() );

	-create a functional interface with an abstract method [BufferedReader -> String].
		@FunctionalInterface
		public interface BufferedReaderProcessor {
			String process(BufferedReader b) throws IOException; <==================== Exception with lambda [or you can use try/catch] *****
		}
	-create a method that takes the functional interface as a signature and does something with it.
		public static String processFile(BufferedReaderProcessor p) throws IOException {
			try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
				return p.process(br); <=============================================== [BufferedReader -> String]
			} 
		}
	-now call the method that uses the functional interface as its signature,
	 substitute the interface name by the lambda expression
	 	String oneLine  = processFile( (BufferedReader br) -> br.readline() );
	 	String twoLines = processFile( (BufferedReader br) -> br.readline() + br.readline() );


=====
EX_2:	Predicate..test() T -> boolean

	-create filter(list<T>, predicate<T>) that [test()]s each element for a true/false value.
		public static <T> List<T> filter(List<T> list, Predicate<T> p) {
			List<T> result = new ArrayList<>();
			for(T s: list){
				if(p.test(s)){
					results.add(s);
				}
			}
			return results;
		}
	-usage:
		Predicate<String> nonEmptyStringPredicate = (String s) -> s.!s.isEmpty();
		List<String> strString = filter(listOfStrings, nonEmptyStringPredicate);


=====
EX_3:	Consumer..accept() T -> void
	
	-create a method that takes a list and a consumer [accept()] lambda expression [ T -> void]
		public static<T> void forEach(List<T> list, Consumer<T> c){
			for (T i: list){
				c.accept(i);
			}
		}
	-usage:
		forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i) );


=====
EX_4:	Function..apply() T -> R	
	-ex: transform a list of Strings to a list of Integer.
		public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
			List<R> result = new ArrayList<>();
			for (T s: list){
				result.add(f.apply(s));
			}
			return result;
		}
		//[7, 2, 6]
		List<Integer> l = map(
								Array.asList("Lambdas", "in", "action"),
								(String s) -> s.legth())
							);


=====
=====
convert lambda expressions to method references
EX_5:	Method references:

		File[] hiddenFiles = new File(".").listFiles(new FileFilter(){ 			
			public boolean accept(File file){
				//return file.isHidden();
				return file.isFile();
			}
		});
		
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		 
		File[] hiddenFiles = new File(".").listFiles(File::isFile); 
				
		System.out.println("zHidden Files: " + hiddenFiles.length);
		//=========================
		List<String> str = Arrays.asList("a", "b", "A", "B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2) );
		for (String s : str){
			System.out.println("zfirst sort: " + s);
		}
		//method reference
		str.sort( String::compareToIgnoreCase );
		for (String s : str){
			System.out.println("zfirst sort: " + s);
		}
		//=========================
		Function<String, Integer> stringToInteger = s -> Integer.parseInt(s);
		stringToInteger = Integer::parseInt;
		
		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		contains = List::contains;
		

---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
Functional Descriptor
---------------------
T -> boolean	<================================================================= [function descriptor]
Apple -> boolean	<============================================================= [function descriptor]
(T, U) -> R 	<================================================================= [function descriptor]

Supplier<Apple> s = () -> new Apple(10);<========================================= Supplier<Apple> is called the [Target-Type].


        With type inference: (Apple a1, Apple a2)  <============================== with [type inference]
                Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
                
        Without type inference: (a1, a2)	<===================================== without [type inference]
                Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());


---int portNumber = 1337;
   Runnable r = () -> System.out.println(portNumber); <=========================== lambda captures the local variable 'portNumber': must be effectively 'final'
   r.run();
   //Thread t = new Thread( () -> System.out.println("Hello World") );  t.start();  
      
      
            
--------------------------------------


(String s) -> s.length() .....................................String..s.length()

---
(Integer i) -> System.out.println(i)
---
(int x, int y) -> {	System.out.println("Result: ");		......() -> void
					System.out.println(x+y);
				  }
---				  														  
() -> 42......................................................returns an int 42.
() -> "Iron man"
() -> {return "Iron man"; } 
() -> new Apple(10)
(Apple a) -> { System.out.println(a.getWeight()); } ..........T -> void
---
Runnable r2 = ()  ->  { System.out.println("Lambda Hello world two!"); };
r2.run();

---
Predicate<List<String>> p = (List<String> list) -> list.isEmpty();

Supplier<Apple> s = () -> new Apple(10);

Consumer<Apple> c = (Apple a) -> System..out.println( a.getWeight() );

ToIntFunction<String> f = (String s) -> s.length();

BiFunction<Apple, Apple, Integer> bf = (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight());
Comparator<Apple> C 				 = (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight());
ToIntBiFunction<Apple, Apple> tibf 	 = (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight());

PrivilegedAction<Integer> p = () -> 42;

Callable<Integer> p = () -> 42;



============================================================================================
============================================================================================
============================================================================================
java timer

		Come on guys! Nobody mentioned the Guava way to do that (which is arguably awesome):

		import com.google.common.base.Stopwatch;

				Stopwatch timer = Stopwatch.createStarted();
				//method invocation
				LOG.info("Method took: " + timer.stop());


		The nice thing is that Stopwatch.toString() does a good job of selecting time units for the measurement.
		 I.e. if the value is small, it'll output 38 ns, if it's long, it'll show 5m 3s

		-Unfortunately, Guava's Stopwatch isn't thread-safe.  
		--------------------------------------------------------------------------------------------


		long startTime = System.nanoTime();
		methodToTime();
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.


		--------------------------------------------------------------------------------------------


		long startTime = System.currentTimeMillis();

		doReallyLongThing();

		long endTime = System.currentTimeMillis();

		System.out.println("That took " + (endTime - startTime) + " milliseconds");

		--------------------------------------------------------------------------------------------

		http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java


			System.currentTimeMillis(); IS NOT a good approach for measuring performance of your logarithms.
			It meassures the total time you experience as a user watching the computer screen, 
			waiting till the program finishes. It includes even time consumed 
			by everything else ruining on your computer in the background. This could make a huge difference 
			in case you have a lot of programs running on your workstation.

			
			Proper approach is using java.lang.management package.
			

			From http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking website:

			"User time" is the time spent running your application's own code.
			"System time" is the time spent running OS code on behalf of your application (such as for I/O).
			getCpuTime() method gives you sum of those:

			import java.lang.management.ManagementFactory;
			import java.lang.management.ThreadMXBean;

			public class CPUUtils {

				/** Get CPU time in nanoseconds. */
				public static long getCpuTime( ) {
					ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
					return bean.isCurrentThreadCpuTimeSupported( ) ?
						bean.getCurrentThreadCpuTime( ) : 0L;
				}

				/** Get user time in nanoseconds. */
				public static long getUserTime( ) {
					ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
					return bean.isCurrentThreadCpuTimeSupported( ) ?
						bean.getCurrentThreadUserTime( ) : 0L;
				}

				/** Get system time in nanoseconds. */
				public static long getSystemTime( ) {
					ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
					return bean.isCurrentThreadCpuTimeSupported( ) ?
						(bean.getCurrentThreadCpuTime( ) - bean.getCurrentThreadUserTime( )) : 0L;
				}

			}







	

