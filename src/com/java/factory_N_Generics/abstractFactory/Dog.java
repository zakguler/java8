package com.java.factory_N_Generics.abstractFactory;

public class Dog implements Animal {
	 
    @Override
    public String getAnimal() {
        return "Dog";
    }
 
    @Override
    public String makeSound() {
        return "Woof";
    }
}