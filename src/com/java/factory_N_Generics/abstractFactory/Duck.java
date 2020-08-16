package com.java.factory_N_Generics.abstractFactory;

public class Duck implements Animal {
	 
    @Override
    public String getAnimal() {
        return "Duck";
    }
 
    @Override
    public String makeSound() {
        return "Squeks";
    }
}
