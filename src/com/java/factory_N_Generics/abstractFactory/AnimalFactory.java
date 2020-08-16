package com.java.factory_N_Generics.abstractFactory;

// Note: https://www.baeldung.com/java-abstract-factory-pattern

public class AnimalFactory implements AbstractFactory<Animal> {
	 
    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }
 
        return null;
    }
 
}
