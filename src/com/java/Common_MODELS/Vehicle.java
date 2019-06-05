package com.java.Common_MODELS;

public interface Vehicle {
	
    public void move();
    
    default void hoot() {
        System.out.println("peep!");
    }
}