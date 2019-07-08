# java 8,9,10 updates
-----------------------

-java 9: Modules and reactive programming toolkit. [synchronization/parallel programming]
-java 11: new synchronous HTTP client library
-Lambda: anonymous functions.
-stream: let you manipulate collections of data in a declarative way. 


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
.Stream()
.parallelStream()

	.filter
	.sort
	.map
	.flatmap ???
	.Collect [terminal operation]............ List<String> asList = stringStream.collect(Collectors.toList());
			(Collectors..toList()
			(Collectors..groupingBy(Person::getCity)
			
			
	-generating a stream from an ordered collection preserves the ordering.
	 	
zak	 	
	 	
	 		


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


			
==================================================================================================
			
			
[.collect(Collectors.groupingBy()]
		[Map] toList
					Map<Department,List<Employee>> employeeMap = 
						employeeList.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment));
					
						System.out.println("Employees grouped by department");
						
						employeeMap.forEach((Department key, List<Employee> empList) -> System.out.println(key +" -> "+empList));
					
					}

		---
		[Map] toSet
					Map<Department,Set<Employee>> employeeMap2 = 
							employeeList.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
						
					System.out.println("Employees grouped by department");
					  
					employeeMap2.forEach((Department key, Set<Employee> empSet) -> System.out.println(key +" -> "+empSet));

		---
		[Map] [new TreeMap type]  toSet			
					Map<Department,Set<Employee>> employeeMap5
							= employeeList.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.toSet()));
						  employeeMap5.forEach((Department key, Set<Employee> empSet) -> System.out.println(key +" -> "+empSet));

						  
		---
		[groupingByConcurrent()] same as above

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
>http://www.baeldung.com/java-8-interview-questions

>[optionals]

	package com.zak.optionals;



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







	

