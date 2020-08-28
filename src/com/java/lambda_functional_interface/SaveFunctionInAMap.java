package com.java.lambda_functional_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

// stupid program to show how to save a function in a map :(

public class SaveFunctionInAMap {

	static Map<String, BiFunction<String, Integer, Fruit>> mapZ = new HashMap<>();
	static {
		mapZ.put("apple", Apple::new);
		mapZ.put("orange", Orange::new);
	}
	
	// create a fruit object + weight based on the fruit name and the provided weight
	public static Fruit giveMeFruit (String fruit, Integer weight) {
		return mapZ.get(fruit.toLowerCase())
				   .apply(fruit, weight);
	}
	
	public static void main(String[] args) {
		// create another Map with new objects+with weights:
		Map <String, Object> mapFruit = new HashMap<>();
		String fruitName = "orange";
		mapFruit.put(fruitName, SaveFunctionInAMap.giveMeFruit(fruitName, 20));
		fruitName = "apple";
		mapFruit.put(fruitName, SaveFunctionInAMap.giveMeFruit(fruitName, 30));
		
		mapFruit.forEach( (k,v ) -> System.out.println( k + " : " + v.toString())  );
		// output:
		// orange : Orange [weight=20, getName()=orange]
		// apple : Apple [weight=30, getName()=apple]
		
	}

	static class Fruit{
		String name;
		String getName() {
			return this.name;
		}		
	}
	
	static class Apple extends Fruit {
		public Apple(String name, Integer weight) {
			this.name = name;
			this.weight = weight;
		}	
		Integer weight;
		Integer getWeight() {
			return weight;
		}
		void setWeight(Integer weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Apple [weight=" + weight + ", getName()=" + getName() + "]";
		}
		
	}
	static class Orange extends Fruit {
		public Orange(String name, Integer weight) {
			this.name = name;
			this.weight = weight;
		}	
		Integer weight;
		Integer getWeight() {
			return weight;
		}
		void setWeight(Integer weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Orange [weight=" + weight + ", getName()=" + getName() + "]";
		}
	}
	
}
