package com.java.factory_N_Generics.abstractFactory;

public interface AbstractFactory<T> {
    T create(String animalType) ;
}