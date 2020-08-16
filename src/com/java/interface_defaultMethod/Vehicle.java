package com.java.interface_defaultMethod;

@FunctionalInterface
public interface Vehicle {

	// you can have multiple 'implemented' default, static methods
	// for @FunctonalInterface: you can have only one 'abstract' method
	
    public void move();
    
     
    static void static0() {
        System.out.println("peep!..static0()");
    }

    static void hoot0() {
        System.out.println("peep!..hoot0()");
    }

    default void hoot() {
        System.out.println("peep!..hoot()");
    }

    default void hoot2() {
        System.out.println("peep!..hoot2()");
    }
    
}