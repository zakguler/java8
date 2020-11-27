
### Online markdown editor: 
	http://markdown.pioul.fr/

### Basic syntax: 
	https://www.markdownguide.org/basic-syntax/#:~:text=To%20emphasize%20text%20with%20bold,without%20spaces%20around%20the%20letters.

### java 8,9,10,11,12 updates

- java 11: new synchronous HTTP client library
- Lambda: anonymous functions.
- stream: let you manipulate collections of data in a declarative way. 



-----------------------------
-----------------------------
-----------------------------

## java 9: Modules and reactive programming toolkit. [synchronization/parallel programming]
- right click on the project
		- configure
			- create module-info.java
			
- Packing a Java Module as a Standalone Application
	 You package a Java module into a standalone application using the jlink command which comes with the Java SDK. 
- Here is how you package a Java module with jlink :
```
		c:\>jlink
```
- exports com.java.collections.mapList;
	


-----------------------------
-----------------------------
-----------------------------
## make a copy for a list using streams:

	    List<Z_Transaction> transactions = new ArrayList<>(Arrays.asList(
	            new Z_Transaction("a12", 2011, 300),
	            new Z_Transaction("c14", 2012, 1000),
	            new Z_Transaction("b13", 2011, 400),
	            new Z_Transaction("720", 2012, 710),
	            new Z_Transaction("344", 2012, 700),
	            new Z_Transaction("983", 2012, 950)
	        ));
	    
	    // generate new copy
	    List<Z_Transaction> transactions1 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions2 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions3 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions4 = transactions.stream().collect(Collectors.toList());
	    List<Z_Transaction> transactions5 = transactions.stream().collect(Collectors.toList());


-----------------------------
-----------------------------
-----------------------------
## Collection Enhancements
## Immutable Collections
### Collection Factories
- List Factory  
- Set Factory  
- Map Factory  


**NEW**
- *List.of()*
- *Set.of()*
- *Map.of()*
- *Map.ofEntries()*  

### new ArrayList<>():  
```	
		List<String> friends = new ArrayList<>();  
		friends.add("Raphael");  
		friends.add("Olivia");  
		friends.add("Thibaut");  
```

### Arrays.asList("Raphael", "Olivia")    
- can update but can NOT add new elements.  
- you can change that by using new ArrayList(...) or new HasSet:  
		_Set<String> friends = new HashSet<>(Arrays.asList("Raphael", "Olivia", Thibaut"));_

```	
		List<String> friends = Arrays.asList("Raphael", "Olivia");  
		friends.set(0, "Richard");  
		friends.add("Thibaut");   
```
### Stream.of("Raphael", "Olivia", "Thibaut")..  
```
		Set<String> friends = Stream.of("Raphael", "Olivia", "Thibaut")  
		 .collect(Collectors.toSet());
```

### __NEW__  

- List.of(("Raphael", "Olivia", "Thibaut")  
	- you still can NOT add elements to it. 
	- can NOT modify elements.  
	- does not accept null element.  
```
		List<String> friends = List.of("Raphael", "Olivia", "Thibaut");
```

- Set.of
	- can NOT contain a duplicated element.
	- you still can NOT add elements to it. 
	- can NOT modify elements.  
	
```
		Set<String> friends = Set.of("Raphael", "Olivia", "Thibaut");
		
		Set<String> friends = Set.of("Raphael", "Olivia", "Olivia"); <== java.lang.IllegalArgumentException: duplicate element: Olivia
```

- Map.of()
- Map.ofEntries()
 
	- Map.of() create up to 10 key/map fields  
	- for more element, bigger/more elements use Map.ofEntries()  
	- will mutate (changes) the same collection  
	- unlike the stream, it produces a new reult (copy's it).   
	
	
```
		Map<String, Integer> ageOfFriends
 							= Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
 		
 		import static java.util.Map.entry;
		Map<String, Integer> ageOfFriends
							 = Map.ofEntries(entry("Raphael", 30),
							 				 entry("Olivia", 25),
							 				 entry("Thibaut", 26));
							 
```








-----------------------------
-----------------------------
-----------------------------

## Functional Interfaces Summary
---

- Predicate.test() ............. T -> boolean

- Consumer.accept() ............ T -> void
- BiConsumer() ................. (T, U) -> void

- Supplier.get() ............... () -> T

- Function.apply() ............. T -> R

- BinaryOperator ............... (T, T) -> T

---




## Functional Interfaces

you can use lambda expression in the context of a Functional Interface 
- contains ONLY one abstract method.
- there is one exception to the rule that only one abstract method is allowed - 
- a functional interface can have another abstract methods if they are implemented by java.lang.Object, 
- for example toString().
```
 (parameters) -> expression
 (parameters) -> {statements; }	<== Block style lambda 
```

- Package java.util.function


### Functions

- T: T stands for "Type"... Object of generic type ***first argument***
- U: type -second argument
- L: ???
- R: Object of generic type return/result
- boolean: true/false
```
- Function Descriptor:
 () -> void
 (T, T) -> R 
```
	Function								 Functional descriptor
	--------								 ----------------------
	Comparator..compare()................... (T, T) -> R.... personList.sort( (Person p1, Person p2)  ->  p1.getSurName().compareTo(p2.getSurName()) );
	Comparator..comparing()................. Comparator<Apple> c = Comparator.comparing(Apple::getWeight());
	Comparable..compareTo().................



### Predicate
- .test()............................. T -> boolean... List<String> strString = filter( listOfStrings, (String s) -> s.!s.isEmpty() );

- .isEqual()

- .negate()
```
	Predicate<Apple> redApple = (a -> a.getColor().equal(COLOR.RED) );
	Predicate<Apple> notRedApple = redApple.negate();
	
```
- .and()
```
	Predicate<Apple> redAndHeavyApple = redApple.and(a->a.getWeight()>150);
```
- .or()
```
	Predicate<Apple> redAndHeavyOrGreenApple =
				redApple
				.and(a->a.getWeight()>150)
				.or(a -> a.getColor().equal(COLOR.GREEN))
	
	so, a.or(b).and(c)	must be read as: (a || b) && c
		a.and(b).or(c) must be read as: (a && b) || c	
```		
	
- IntPredicate..test(int i)............... int -> boolean..... IntPredicate evenNumbers = (int i) -> i % 2 == 0;
- DoublePredicate
- BiPredicate............................. (L, R) -> boolean

```	
	NOTE: Special void-compatibility rule
		If a lambda has a statement expression as its body, it’s compatible with a function
		descriptor that returns void (provided the parameter list is compatible, too). For
		example, both of the following lines are legal even though the method add of a List
		returns a boolean and not void as expected in the Consumer context (T -> void):
			// Predicate has a boolean return
			Predicate<String> p = (String s) -> list.add(s);
			// Consumer has a void return
			Consumer<String> b = (String s) -> list.add(s);
```
	
	
### Consumer.
- .accept()........................... T -> void
```
 	forEach(Arrays.asList(1,2,3,4,5),(Integer i) -> System.out.println(i) );
```
- IntConsumer
- BiConsumer.......................... (T, U) -> void


		
### Function.
- zGeneric(T) -> zGeneric(R)

- .apply()....................... T -> R
```
	List<Integer> l = zMap(Array.asList( "Lambdas", "in", "action"), (String s) -> s.legth()));
	..
	public List<Integer> zMap(List<String> list, Function f){
		List<Integer> i = ArrayList<>();
		for (String s: list){
			i.add(f.apply(s));
		}
	}
```
- .andThen()..................... f.andThen(g) ===> g(f(x))
```
	static Function<Integer, Integer> f = x -> x + 1;
	static Function<Integer, Integer> g = x -> x * 2;	
	static Function<Integer, Integer> h = f.andThen(g);	// g(f(x))
	..
	int result = h.apply(1);	// 1+1 *2 = 4
```
- .compose()..................... f.compose(g) ===> f(g(x))
```
	static Function<Integer, Integer> f = x -> x + 1;
	static Function<Integer, Integer> g = x -> x * 2;	
	static Function<Integer, Integer> m = f.compose(g);	// f(g(x))
	..
	int result = m.apply(1);	// 1*2 +1 = 3

```

- IntFunction
- ToIntFunction							 T -> int
- IntToDoubleFunction
- BiFunction..apply().....................(T, U) -> R....................... (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight())
- ToIntBiFunction<T,T>....................(T,T) -> int

	
	
### Supplier.
- .get()							() -> T......... () -> new Apple(10)  //it takes one argument and returns a result
	
- BinaryOperator..					(T, T) -> T
- IntBinaryOperator..				(int, int) -> int................. (int a, int b) -> A * b
- LongBinaryOperator
	
- UnaryOperator..					T -> T



=============================
=============================
=============================
## method reference... _double colon_ '::' 

```	
http://www.baeldung.com/java-8-double-colon-operator
```
 **Bound** *t2*........................ Supplier<String> supplier = t2::method;
 
 **UnBoundc** *lass/instance name*..... Function<Test, String> function = Test::method;
```	
EX with [lambda] 
		inventory.sort( (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) );
		
   with [method reference]		
		inventory.sort(Comparator.comparing(Apple::getWeight)); 
		inventory.sort( Comparator.comparing(Apple::getWeight).reversed() ); 
	
   Composing:	
   with [.then] if weight the same further comparison needed,  ex, by country:
 		inventory.sort(Comparator.comparing(Apple::getWeight)
 						.reversed()
 						.thenComparing(Apple::getCountry)
 					  );   					
```

    Lambda Method                                       reference equivalent
        
    (Apple a) -> a.getWeight() ........................ Apple::getWeight
    () -> Thread.currentThread().dumpStack() .......... Thread.currentThread()::dumpStack
    (str, i) -> str.substring(i) ...................... String::substring
    (String s) -> System.out.println(s) ............... System.out::println  
    (String s) -> this.isValidName(s).................. this::isValidName
           

- static method.................................... Integer::parseInt
- instance method.................................. String::length
- local method Transaction expensiveTransaction.... expensiveTransaction::getValue 
	
- constructors reference.. with 0 arguments................... [new Apple()]=========>	Supplier<Apple> s = Apple::new; Apple a1 = s.get();
	
- constructors reference.. with 1 arguments................... [new Apple(weight)]===>	Function<Integer, Apple> s = Apple::new; Apple a1 = s.get(110);
	
- constructors reference.. with 2 arguments................... [new Apple(color, weight)]===>	BiFunction<Color, Integer, Apple> s = Apple::new; Apple a1 = s.get(GREEN, 110);
	
- constructors reference.. with 3 arguments................... create your own CustomTriFunction<T, U, V, R>... see example below
	
```	
	EX:
		[constructors reference][with 3 arguments]................... create your own CustomTriFunction<T, U, V, R>
			public interface CustomTriFunction<T, U, V, R> {
				R apply(T t, U u, V v);
			}
			..
			CustomTriFunction<Integer, Integer, Integer, RGB> colorFactory = RGB::new;
			
	EX: expensiveTransaction = new Transaction();
		expensiveTransaction::getValue;	<====================== () -> expensiveTransaction.getValue();
```	
- [array constructors] ???
- [super calls] ???
	
	
	

- https://stackoverflow.com/questions/35914775/java-8-difference-between-method-reference-bound-receiver-and-unbound-receiver
- Java 8: Difference between method reference Bound Receiver and UnBound Receiver
```
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
```

```
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
```

=============================
=============================
=============================

# Streams

## numeric streams [primitive]:

- intStream
- doubleStream
- longStream

- mapToInt
- mapToDouble
- mapToLong

	- sum()	<==== default 0
	
- converting from primitive stream to a stream of objects:
```
IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
Stream<Integer> stream = intStream.boxed(); <=== you have to box the IntStream<int> to convert it to a stream<Integer>
```

- OptionalInt
- OptionalDouble
- OptionalLong
	- max()	<==== default CAN'T be 0
	- min()
	- average()

	- orElse(5) <==== returns primitive value of int '5' [not optional int]


## numeric rage:
- range	<================ exclusive (2, 5) '5' is not included: 2,3,4
- rangeClosed	<======== inclusive (2, 5) '5' is included: 2,3,4,5




## building streams:
- Stream.of("a", "b", "c")................................... from values 
- Stream.empty()............................................. empty stream 
- Stream.ofNullable()........................................ from nullable: if no value found, it will create Stream.empty otherwise Stream.of() vlaue
- Arrays.stream(new String[]{"a", "b", "c", "d", "e"})....... from Arrays
- (Arrays.asList("a", "b", "c")).stream()
- Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())...... from files
- Stream.iterate(0, n->n+2).limit(10)........................ from infinite stream
- IntStream.range(1, 100).................................... 


- Building streams [summary]:
```	
	Stream.of()
		Stream<String> s = Stream.of("Modern ", "Java ", "In ", "Action");
	Stream.empty()
		Stream<String> emptyStream = Stream.empty();	// get an empty stream
	Stream.ofNullable(
		[Java9]
			Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));
	Arrays.stream()
		int sum = Arrays.stream( {2, 3, 5, 7, 11, 13} ).sum();
	list2.stream()
		[from a List]
			List<String> list2 = Arrays.asList("a", "b", "c"); Stream<String> streamL2 = list2.stream();
	collc.stream()
		[from a Collection]
			Collection<String> collection = Arrays.asList("a", "b", "c"); 
			Stream<String> streamOfCollection = collection.stream();
		[from a file]
			try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {....}
	
	map.entrySet().stream()
		[from a map]
			Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
			Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();
 
	map.keySet().stream
		[from a map..key]
			Set<String> keySet = someMap.keySet();
			Stream<String> keysStream = keySet.stream();
					
	map.values().stream
		[from a map..value]
			Collection<Integer> values = someMap.values();
			Stream<Integer> valuesStream = values.stream();
												 
	Stream.iterate(x,y)
		[infinite stream]
			Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
	
	java9
	IntStream.iterate(x,y,z)
		IntStream.iterate(0, n -> n < 100, n -> n + 4)	
			//<=== (starting, predicate, lambda function).forEach(System.out::println);
	
	Stream.generate()
		[infinite stream]
			Stream.generate(() -> Double.toString(Math.random() * 1000)).limit(10);
```	



- Stream.concat( Stream(a), Stream(b) )	// also you can use flatMap(): search for an example..
- Stream.of(l1, l2)
- Stream.of(n1, n2).flatMap(Collection::stream);
	
- Arrays.asList("a", "b", "c");
	static List<Dish> specialMenu = Arrays.asList( 
	new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
	new Dish("prawns", false, 300, Dish.Type.FISH));
	
- Stream<String> streamOfWords = Arrays.stream( {"GoodBye", "World"} );



- .stream()
- .parallelStream()

	- stream pipeline is similar to the [builder pattern] [chain of calls]
				 (see http://en.wikipedia.org/wiki/Builder_pattern)
	
	- generating a stream from an ordered collection preserves the ordering.

	- Stateless vs stateful
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
			
	------------------------------ 	
	------------------------------
	[.distinct] 
		// you can use it to remove duplicates
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
				.filter(i -> i % 2 == 0)
				.distinct()
				.forEach(System.out::println);
 	
 	slicing 
 	[.takeWhile]
 		// [already sorted elements] use to stop (selecting) filtering when it is true
 			import static java.util.stream.Collectors.*;
			List<Dish> filteredMenu = specialMenu
				.stream()
				.takeWhile(dish -> dish.getCalories() < 320) // [must be a sorted list] +stops once a dish found >= 320
				.collect(toList());

 	slicing 
 	[.dropWhile]
 		// [already sorted elements] use to select filtering when the ones that's not true [the opposite of .takeWhile]
 			import static java.util.stream.Collectors.*;
			List<Dish> filteredMenu = specialMenu
				.stream()
				.dropWhile(dish -> dish.getCalories() < 320) // [must be a sorted list] +starts selecting once a dish found >= 320
				.collect(toList());
 		
		
	 		
	[filter]
	[limit] 	
			import static java.util.stream.Collectors.*;	
	 		List<Dish> dishes = menu
	 			.stream()
				.filter(dish -> dish.getType() == Dish.Type.MEAT)
				.limit(2)
				.collect(toList());

	[filter]
	[skip] 	


	// map is almost like select a particular column in sql
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
			

	Numeric Stream:	
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
			


	Numeric Stream:	
		[IntStream]
		[DoubleStream]
		[LongStream]
			
				-supports: .sum .min .max .average  .rang .rangClosed
					
				IntStream intStream = IntStream.range(1, 100);			// exclusive [1-99] [100 not included]
				IntStream intStream = IntStream.rangeClosed(1, 100)		// inclusive [1-100][100 is included]
											   .filter(n -> n%2 == 0);
				
				
				// converting back to a stream of Objects [int -> Integer]
				IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
				Stream<Integer> stream = intStream.boxed(); <=== you have to box the IntStream<int> to convert it to a stream<Integer>
	
	
			
			
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
					.map(Transaction::getValue)
					.sorted()					
					//.sorted(Comparator.reverseOrder())					
					.forEach(System.out::println);	



## Collection					
## collect					
## Collectors
	
	
- group a list
- partition a list
- grouping and sub-grouping
		
		
### collect()	
		
		import static java.util.stream.Collectors.*;
		
		- Collectors.toList()
			List<Transaction> transactions = transactionStream
												.collect(Collectors.toList());
		
		- Collectors.counting()]		
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
	    	
	    	NOTE:
	    	if Dish has toString() method that returns the dish name, both produce a string value:
	    	String shortMenu = menu.stream().collect(joining());
		
		
		[collecters.reducing(x,y,z)]
			int totalCalories0 = menu.stream().collect(
	    		reducing(0,			//....................... initial value
	    		Dish::getCalories,	//....................... transformation function
	    		Integer::sum));		//....................... aggregating function
			
			int totalCalories2 = menu.stream().collect(reducing( 0, Dish::getCalories, (i, j) -> i + j) );
			Optional<Dish> mostCalorieDish2 = menu.stream().collect(reducing( (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2) );
			
			
			
			
		NOTE: groupingBy(f) ==> shorthand for groupingBy(f, toList())
		NOTE: groupingBy generates a Map<x, list<>)
			OR
			  groupingBy(Map<x, Map<y, list<>>) <=== inner groupingBy
			  	
		NOTE: groupingBy( k.., v[filtering.., output..] )	
		NOTE: groupingBy( k.., v[mapping.., output..] )	
								[counting()
								[maxBy()
		[(Collectors.groupingBy()]
		[groupingByConcurrent()] same as above
		
		
			[Map] [:: method reference]
					Map<Dish.Type, List<Dish>> dishesByType =
							menu.stream().collect(groupingBy(Dish::getType));
							
					[result set]
						{FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizza],
 							MEAT=[pork, beef, chicken]}

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
					[result set]
						NORMAL beef french fries pizza salmon
						DIET chicken rice season fruit prawns
						FAT pork


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
					[result set]
						{OTHER=[french fries, pizza], MEAT=[pork, beef], FISH=[]}						  			  
						  			  
						  			  
						 
			[Map] mapping... toList		  
					Map<Dish.Type, List<Dish>> dishNamesByType =
						  menu.stream()
						  	  .collect(Collectors.groupingBy(Dish::getType,
						  			   Collectors.mapping(Dish::getName, Collectors.toList())
						  			  ));
	
			[flatMap]
					Map<Dish.Type, Set<String>> dishNamesByType =
						 menu.stream()
							 .collect(groupingBy(Dish::getType,
												 flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
												 toSet())));
					[result set]
						{MEAT=[salty, greasy, roasted, fried, crisp], FISH=[roasted, tasty, fresh,
						delicious], OTHER=[salty, greasy, natural, light, tasty, fresh, fried]}						 							  			  
						  			
						  			  
					 
			[Map] multilevel [inner] groupingBy								 
					Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
						  menu.stream()
						  	  .collect(
						 			groupingBy(Dish::getType,
						 					   groupingBy(dish -> {
						 							if (dish.getCalories() <= 400) return CaloricLevel.DIET;
													 else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
													 else return CaloricLevel.FAT;
						 						} )
									)
						);	
						
					[result set]
						{MEAT={DIET=[chicken], NORMAL=[beef], FAT=[pork]},
						 FISH={DIET=[prawns], NORMAL=[salmon]},
						 OTHER={DIET=[rice, seasonal fruit], NORMAL=[french fries, pizza]}}	 		


			[Map] counting()
					Map<Dish.Type, Long> typesCount = menu.stream()
							.collect( groupingBy(Dish::getType, counting())  );

					[result set]
						{MEAT=3, FISH=2, OTHER=4}


			NOTE: groupingBy(f) ==> shorthand for groupingBy(f, toList())



			[TOTAL]
			[summingInt]
			Map<Type, Integer> typeByToalCalories = 
					menu.stream()
					.collect(Collectors.groupingBy(Dish::getType
							,Collectors.summingInt(Dish::getCalories) 
							));
			
			typeByToalCalories.forEach((k, v) -> {
				System.out.println(k + ": " + v);
			});
			
			
			
			[Map] maxBy() 
				Map<Dish.Type, Optional<Dish>> mostCaloricByType =
						 menu.stream()
						 	.collect(groupingBy(Dish::getType,
						 						maxBy(comparingInt(Dish::getCalories))));

					[result set]
						this can return Optional.empty !!!
***						{FISH=Optional[salmon], OTHER=Optional[pizza], MEAT=Optional[pork]}

				Map<Dish.Type, Dish> mostCaloricByType =
					 menu.stream()
						 .collect(groupingBy(Dish::getType,
									 collectingAndThen(
										 maxBy(comparingInt(Dish::getCalories)), Optional::get))); 
					[result set]
***						{FISH=salmon, OTHER=pizza, MEAT=pork}
						
	
	
						

### collect
- collector
	- partitioningBy
	- groupingBy
	- collectingAndThen	<=== can be used to get a single value
	- maxBy

```
		System.out.println("\n=====================================================");
		System.out.println("-----partitioningBy isVegetarian ? ");

//		Map<Boolean, List<Dish>> partitioningByIsVegetarian =
//				 menu.stream()
//				 .collect(Collectors.partitioningBy(
//						 	dish -> dish.getType().equals(Dish.Type.OTHER)
//						 	)); 
		
		Map<Boolean, List<Dish>> partitioningByIsVegetarian =
				menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian)); 
		
		partitioningByIsVegetarian.forEach((k, v) -> {
			System.out.print(k + ": "); 
			System.out.println( v.stream().map(d->d.getName()).collect(Collectors.joining(", ")) );
		});

		List<Dish> vegetarianDishes = partitioningByIsVegetarian.get(true);

		
		System.out.println("\n=====================================================");
		System.out.println("-----partitioningBy_n_groupingBy multi level ");

		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
				menu.stream().collect(
				 partitioningBy(Dish::isVegetarian,
				 groupingBy(Dish::getType))); 
		
		vegetarianDishesByType.forEach((k, v) -> {
			System.out.print(k + " (k): "); 
			v.forEach((k2,v2)->{
				System.out.print(k2 + " (k2): ");
				System.out.println(v2.stream().map(d->d.getName()).collect(Collectors.joining(", ")));
			});
			
		});


		System.out.println("\n=====================================================");
		System.out.println("-----partitioningBy:");
		System.out.println("find the most caloric dish among both vegetarian and nonvegetarian dishes::");

		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
				menu.stream().collect(
				 partitioningBy(Dish::isVegetarian,
				 collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
				 Optional::get)));
		// That will produce the following result:
		// {false=pork, true=pizza}
		

```



## The Collector Interface
### build a collector interface

### List Factory:
- List.of()
	- immutable List  
	- you can't add/modify the list: friends.add("Sam"); <=== Exception  
	- null elements are disallowed.  
	
	- List<String> friends = List.of("Raphael", "Olivia", "Thibaut");  
	  System.out.println(friends); 


### Set Factory
- Set.of()
	- immutable Set
	- no duplicates.
	
	- Set<String> friends = Set.of("Raphael", "Olivia", "Thibaut");  
	  System.out.println(friends); 
	


### Map Factory
- Map.of()
	- immutable Map  
	- up to 10 keys and values
	
	- Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
	  System.out.println(ageOfFriends); 

	- for more than 10 keys and values,
	  use:
```
			import static java.util.Map.entry;
			Map<String, Integer> ageOfFriends
				 = Map.ofEntries(entry("Raphael", 30),
								 entry("Olivia", 25),
								 entry("Thibaut", 26));
			 
			System.out.println(ageOfFriends); 
```


### Working with List and Set


- transactions.removeIf()
	- List<Transactions> transactions ...
	  transactions.removeIf(t -> t...Predicate...);
	  
	  
- referenceCodes.replaceAll()
	- List<String> referenceCodes ...
	  referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));


### Working with Map
```
		// Working with Map
		// Map.of()
		Map<String, Integer> ageOfFriends
		= Map.ofEntries(entry("Raphael", 30),
			 			entry("Olivia", 25),
			 			entry("Thibaut", 26));	
		System.out.println(ageOfFriends);
		
		System.out.println("==for================================================");		
		// for
		for(Map.Entry<String, Integer> entry: ageOfFriends.entrySet()) {
			String friend = entry.getKey();
			Integer age = entry.getValue();
			System.out.println(friend + " is " + age + " years old");
		}
		
		
		System.out.println("==forEach============================================");
		// forEach
//		ageOfFriends.forEach( (k,v)->{
//			System.out.print(k);
//			System.out.println(v);
//		});
		ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " +
				age + " years old"));

		
		
		System.out.println("==sorted=============================================");
		// Processes the elements of
		// the stream in alphabetic
		// order based on the
		// person’s name
		
		Map<String, String> favouriteMovies
		 = Map.ofEntries(entry("Raphael", "Star Wars"),
						 entry("Cristina", "Matrix"),
						 entry("Olivia", "James Bond"));
		
		favouriteMovies
		 .entrySet()
		 .stream()
		 .sorted(Entry.comparingByKey())
		 .forEachOrdered(System.out::println);
		
		
		System.out.println("==map..get(): getOrDefault============================");
		// 
		Map<String, String> favouriteMovies_2
		 = Map.ofEntries(entry("Raphael", "Star Wars"),
		 entry("Olivia", "James Bond"));
		
		// Outputs James Bond
		System.out.println(favouriteMovies_2.getOrDefault("Olivia", "Matrix"));
		// Outputs Matrix
		System.out.println(favouriteMovies_2.getOrDefault("Thibaut", "Matrix")); 
		
		
		System.out.println("=====================================================");
		// -computeIfAbsent—If there’s no specified value for the given key (it’s absent or its value is null), calculate a new value by using the key and add it to the Map.
		// -computeIfPresent—If the specified key is present, calculate a new value for it and add it to the Map.
		// -compute—This operation calculates a new value for a given key and stores it in the Map.		
		System.out.println("==Map..computeIfAbsent()===============");
		
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		friendsToMovies.put(
					"Sam", new ArrayList<String>(Arrays.asList("The Birds","Terminator"))
					); 
		friendsToMovies.put(
				"Alan", new ArrayList<String>(Arrays.asList("good bye, love","Jaws"))
				); 
		
		// Current style
		String friend = "Raphael";
		List<String> movies = friendsToMovies.get(friend);
		if(movies == null) {
			 movies = new ArrayList<>();
			 friendsToMovies.put(friend, movies);
		}
		movies.add("Star Wars");		
		System.out.println(friendsToMovies); 
		
		// newer using: Map..computeIfAbsent()
		friendsToMovies
			.computeIfAbsent("James", name -> new ArrayList<>())
		 	.add("Star Wars"); 
		
		System.out.println(friendsToMovies);
		
		
		System.out.println("\n==Map..computeIfPresent()===============");
		System.out.println("==see notes in the code  ===============");
		// The computeIfPresent method calculates a new value if the current value associated
		// with the key is present in the Map and non-null. Note a subtlety: if the function that
		// produces the value returns null, the current mapping is removed from the Map. If you
		// need to remove a mapping, however, an overloaded version of the remove method is
		// better suited to the task. You learn about this method in the next section.

		
		System.out.println("\n==Map..remove()==================================================");

		// current
		Map favouriteMovies_4 = new HashMap<>();
		String key = "Raphael";
		String value = "Jack Reacher 2";
		favouriteMovies_4.put(key, value);
		System.out.println(favouriteMovies_4);
		if (favouriteMovies_4.containsKey(key) &&
			Objects.equals(favouriteMovies_4.get(key), value)) {
			favouriteMovies_4.remove(key);
			 System.out.println("Current usage: Map..remove: true");
		}
		else {
			 System.out.println("Current usage: Map..remove: flase");
		}

		// newer
		favouriteMovies_4.put(key, value);
		System.out.println(favouriteMovies_4);
		favouriteMovies_4.remove(key, value);
		System.out.println("Newer usage: Map..remove: success");
		
		System.out.println("\n==Map..replaceAll()/replace()==================================================");
		
		Map<String, String> favouriteMovies_3 = new HashMap<>();
		favouriteMovies_3.put("Raphael", "Star Wars");
		favouriteMovies_3.put("Olivia", "james bond");
		System.out.println(favouriteMovies_3);
//		favouriteMovies_3.replaceAll((friend, movie) -> movie.toUpperCase());
		favouriteMovies_3.replaceAll((k, v) -> v.toUpperCase());
		System.out.println(favouriteMovies_3);
		
		
		System.out.println("\n==Map..removeIf()==================================================");
		
		// current
		Map<String, Integer> movies_2 = new HashMap<>();
		movies_2.put("JamesBond", 20);
		movies_2.put("Matrix", 15);
		movies_2.put("Harry Potter", 5);
		
		Iterator<Map.Entry<String, Integer>> iterator =
				movies_2.entrySet().iterator();
		while(iterator.hasNext()) {
		 Map.Entry<String, Integer> entry = iterator.next();
		 if(entry.getValue() < 10) {
		 iterator.remove();
		 }
		}
		System.out.println(movies_2); 
		
		// newer
		movies_2.entrySet().removeIf(entry -> entry.getValue() < 10);
		

```


### Improved ConcurrentHashMap
```
		// 
		// -forEach—Performs a given action for each (key, value)
		// -reduce—Combines all (key, value) given a reduction function into a result
		// -search—Applies a function on each (key, value) until the function produces a non-null result
		
		// Each kind of operation supports four forms, accepting functions with keys, values,
		// Map.Entry, and (key, value) arguments:
		// -Operates with keys and values (forEach, reduce, search)
		// -Operates with keys (forEachKey, reduceKeys, searchKeys)
		// -Operates with values (forEachValue, reduceValues, searchValues)
		// -Operates with Map.Entry objects (forEachEntry, reduceEntries, searchEntries)
		
		// counting:
		// -mappingCount
		
		// set views:
		//	-newKeySet

```




### refactoring, testing and debugging

zak???






=============================
=============================
=============================
## functional programming

- First Class Function
- Higher Order Function
- Currying





### Currying
```
Unit conversion Example:
	CtoF(x) = x*9/5 + 32;
	
	//---
	static double converter(double x, double f, double b) {
		return x * f + b;
	}
	
	//--- Currying
	// 1:
	static DoubleUnaryOperator curriedConverter(double f, double b){
	 return (double x) -> x * f + b;
	}

	// build multiple functions(x)
	// 2:
	DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
	DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
	DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

	// example on how to use one of the function(x)-in-function(f,b)
	// 3:
	double gbp = convertUSDtoGBP.applyAsDouble(1000);

```

=============================
=============================
=============================
## Paraller

	-parallelStream()
	- .parallel()
	- .sequential()
	
	- is not Parallel friendly
		- Stream.iterate(1L, i->i+1).limit(90).reduce(0L, Long::sum); <== much slower
		
	- parallel friendly:
		-LongStream.rangeClosed(1, 99).reduce(0L, Long::sum);
		-LongStream.rangeClosed(1, 99).parallel().reduce(0L, Long::sum); <== faster
		

	 stream.parallel()
		 	 .filter(...)
			 .sequential()
			 .map(...)
			 .parallel()
			 .reduce();
		 
	But the last call to parallel or sequential wins and affects the pipeline globally. In
	this example, the pipeline will be executed in parallel because that’s the last call in the
	pipeline.





##  Measuring stream performance 
	To this purpose we will implement a microbenchmark using a library called Java Microbenchmark Harness (JMH). 

Zak???




## fork / join framework

Zak???



## Spliterator

	- iterator in parallel.
	










=============================
=============================
=============================
#[switch] with [lambda] expression:
#[Java 12]

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


=============================
=============================
=============================
#Target type
	-Predicate<List<String>>.......	Target type is:	<List<String>>
	-Consumer<Apple>............... Target type is:	<Apple>	
	

-----	
#Cast expression

	Object o = () -> {System.out.println("example"); };	<=== won't compile
	
	Object o = (Runnable) () -> {System.out.println("example"); };	<=== won't compile
			T-> void
			
	OR
		Runnable r = () -> {System.out.println("example"); };	<=== won't compile

=============================
=============================
=============================
ActionListener..actionPerformed()....... jpfPassword.addActionListener(e -> nOKButton.doClick());
EventHandle..handle()................... button.setOnAction( (ActionEvent event) -> lable.setText("Sent!!") );

PrivilegedAction..run()................. () -> T........ PrivilegedAction<Integer> p = () -> 42;
Callable..call()........................ () -> T........ Callable<Integer> p = () -> 42;

Runnable..run()......................... () -> void..... Thread t = new Thread( () -> System.out.println("Hello World") ); 
														 t.start();
														 
														 Runnable task = () -> {
															    String threadName = Thread.currentThread().getName();
															    System.out.println("Hello " + threadName);
															};														
															task.run();
															
															Thread thread = new Thread(task);
															thread.start();



=============================
=============================
=============================
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
		
		
=============================
#[sort]  inventory.sort(Comparator.comparing(Apple::getWeight));
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed()); 
		
		inventory.sort(Comparator.comparing(Apple::getWeight) 			// sort by decreasing weight
						.reversed()
						.thenComparing(Apple::getCountry)); // sort further by country when apples have the same weight.
		

		personList.sort( (Person p1, Person p2)  ->  p1.getSurName().compareTo(p2.getSurName()) );
		inventory.sort( (Apple a1, Apple a2)  ->  a1.getWeight().compareTo(a2.getWeight()) );
		strList.sort((s1, s2) -> s1.compareToIgnoreCase(s2) );	
		strList.sort( String::compareToIgnoreCase );
		
		
=============================
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
					

					
			
=============================
=============================
=============================
# [List][list.removeIf(true/false predicate)]

	public void updateTopic(String id, Topic topic) {
		Topic t = topics.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();
		topics.set(topics.indexOf(t), topic);	
	}

	public void deleteTopic(String id) {
		topics.removeIf(e-> e.getId().equalsIgnoreCase(id));		
	}



=============================
=============================
=============================
#http://www.baeldung.com/java-nashorn
#Introduction to Nashorn -JavaScript engine for JAVA 8

		This article is focused on Nashorn – the new default JavaScript engine for the JVM as of Java 8.

		What is jjs?
			In Java 8, jjs is the new executable or command line tool used to execute Javascript code at the console.

	
			

============================
#[Optionals]

	menu.stream()
		.filter(Dish::isVegetarian)
		.findAny() //<========================================== returns Optional<Dish>
		.ifPresent(dish -> System.out.println(dish.getName());

	[.isPresent()]
	[.ifPresent(execute this block if true)]
	[.get()]
	[.orElse()]
	


=============================
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

	Arrays.stream({"a", "B", "x"});
	
=============================



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
	
	

=============================
=============================
=============================


-[anonymous functions] [lambda] functional programming.
-[Predicate<T>] []Functional Interface]: This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
-[::] [method reference].

-[behavior parameterization] page 28 [java8 in action].
-[streams] collections-like API.
-[streams] for-each loop is called External Iteration.
-[streams] strema API called Internal Iteration.
-[streams] forking step [run in parallel].
-[null pointer exception] use "Optional<T>()" to help avoid null pointer exception.




=============================
=============================
=============================


=============================
=============================
=============================

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


=============================
=============================
=============================
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
		

=============================
=============================
=============================
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
      
      
            
-----------------------------


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



=============================
=============================
=============================
java timer

		Come on guys! Nobody mentioned the Guava way to do that (which is arguably awesome):

		import com.google.common.base.Stopwatch;

				Stopwatch timer = Stopwatch.createStarted();
				//method invocation
				LOG.info("Method took: " + timer.stop());


		The nice thing is that Stopwatch.toString() does a good job of selecting time units for the measurement.
		 I.e. if the value is small, it'll output 38 ns, if it's long, it'll show 5m 3s

		-Unfortunately, Guava's Stopwatch isn't thread-safe.  
		------------------------------


		long startTime = System.nanoTime();
		methodToTime();
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.


		------------------------------


		long startTime = System.currentTimeMillis();

		doReallyLongThing();

		long endTime = System.currentTimeMillis();

		System.out.println("That took " + (endTime - startTime) + " milliseconds");

		------------------------------

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




=============================
=============================
=============================
## Debug Streams
### EX:
```
List<String> names =
	 menu.stream()
		 .filter(dish -> {
				 System.out.println("filtering:" + dish.getName());
				 return dish.getCalories() > 300;
			 })
		 .map(dish -> {
				 System.out.println("mapping:" + dish.getName());
				 return dish.getName();
			 })
		 .limit(3)
 		 .collect(toList());
 		 
System.out.println(names);

This code, when executed, will print the following:
	filtering:pork
	mapping:pork
	filtering:beef
	mapping:beef
	filtering:chicken
	mapping:chicken
	
	[pork, beef, chicken]
```


### Using peek()
- This method exists mainly to support debugging, 
	where you want to see the elements as they flow past a certain point in a pipeline
- between intermediate and terminal operations
- does nothing if it is in the intermediate operations only.

EX2:

```
    Stream.iterate(0, i -> i + 1)
          .limit(5)
          .map(i -> i + 1)
          	.peek(i -> System.out.println("Map: " + i))
          .count()

```
EX3:
```    	// EX3
        Stream.of("one", "two", "three", "four", "five", "six", "Seven")
	        .filter(e -> e.length() > 3)
	        .peek(e -> System.out.println("Filtered value: " + e))
	        .map(String::toUpperCase)
	        .peek(e -> System.out.println("Mapped value: " + e))
	        .collect(Collectors.toList())
	        .forEach(System.out::println);
```


=============================
=============================
=============================

[Data][Examples]

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
	

		Map<String, List<String>> dishTags = new HashMap<>();
			dishTags.put("pork", asList("greasy", "salty"));
			dishTags.put("beef", asList("salty", "roasted"));
			dishTags.put("chicken", asList("fried", "crisp"));
			dishTags.put("french fries", asList("greasy", "fried"));
			dishTags.put("rice", asList("light", "natural"));
			dishTags.put("season fruit", asList("fresh", "natural"));
			dishTags.put("pizza", asList("tasty", "salty"));
			dishTags.put("prawns", asList("tasty", "roasted"));
			dishTags.put("salmon", asList("delicious", "fresh"));
