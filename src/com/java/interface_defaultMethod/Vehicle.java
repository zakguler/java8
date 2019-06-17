package com.java.interface_defaultMethod;

public interface Vehicle {
	
    public void move();
    
    default void hoot() {
        System.out.println("peep!");
    }
}