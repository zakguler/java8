# Generics

### Generic
- List<? extends Number> means that the given list contains objects of some unknown type which extends the Number class. For example, the list could be List<Float> or List<Number>. Reading an element from the list will return a Number. Adding null elements is, again, also allowed.

### Generic class
- generic type comes after the class name
```
	public class Apple<T, R>{..}
```

### Generic Method
- generic type comes before the return type
```
	public static <T> Apple getFruit(){..}
```

### Generic constructor
```
	public Generic_Constructor_EX(T length, T width, T height) {..}
```

