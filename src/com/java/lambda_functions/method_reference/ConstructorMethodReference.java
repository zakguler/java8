package com.java.lambda_functions.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.java.Common_ENUM.Color;

public class ConstructorMethodReference {

	// [constructors][with 0 arguments]................... [new Apple()]=========>	Supplier<Apple> s = Apple::new; Apple a1 = s.get();
	static Supplier<Apple> s1 = Apple::new;
	
	// [constructors][with 1 arguments]................... [new Apple(weight)]===>	Function<Integer, Apple> s = Apple::new; Apple a1 = s.get(110);
	static Function<Integer, Apple> f1 = Apple::new;
	
	// [constructors][with 2 arguments]................... [new Apple(color, weight)]===>	BiFunction<Color, Integer, Apple> s = Apple::new; Apple a1 = s.get(GREEN, 110);
	static BiFunction<Color, Integer, Apple> f2 = Apple::new;

	public static void main(String...args) {
		
		//---
		// [constructors][with 0 arguments]................... [new Apple()]=========>	Supplier<Apple> s = Apple::new; Apple a1 = s.get();
		// Supplier..get()
		Apple a1 = s1.get();
		
		//---
		// [constructors][with 1 arguments]................... [new Apple(weight)]===>	Function<Integer, Apple> s = Apple::new; Apple a1 = s.get(110);
		// Function<Integer, Apple>..apply()
		Apple a2 = f1.apply(2);
		
		// [constructors][with 2 arguments]................... [new Apple(color, weight)]===>	BiFunction<Color, Integer, Apple> s = Apple::new; Apple a1 = s.get(GREEN, 110);
		// BiFunction<Color, Integer, Apple>..apply()
		Apple a3 = f2.apply(Color.GREEN, 2);

		
		//---           ,...
		// In the following L;'''l'l'';'';'''''lm,nm m,m nmm,,,code, each element of a List of Integers is passed to the constructor
		// of Apple using a similar map method we defined earlier, resulting in a List of apples
		// with various weights:
		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		
		List<Apple> apples = map(weights, Apple::new);
	}
	
	//---
	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for(Integer i: list) {
			result.add(f.apply(i));
		}
		return result;
	}
	
	//---
	static class Apple {
		Color c;
		Integer weight;
		
		// constructor with 0 arguments
		public Apple() {
		};
	
		// constructor with 1 arguments
		public Apple(Integer weight) {
			this.weight = weight;
		};
	
		// constructor with 2 arguments
		public Apple(Color c, Integer weight) {
			this.c = c;
			this.weight = weight;
		};
	
		public Color getColor() {
			return c;
		}
	
		public Color getC() {
			return c;
		}
	
		public void setC(Color c) {
			this.c = c;
		}
	
		public Integer getWeight() {
			return weight;
		}
	
		public void setWeight(Integer weight) {
			this.weight = weight;
		}
		
	}

}
