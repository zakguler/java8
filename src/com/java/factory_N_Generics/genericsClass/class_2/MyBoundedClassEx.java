package com.java.factory_N_Generics.genericsClass.class_2;

public class MyBoundedClassEx {
	 
    public static void main(String a[]){
        //Creating object of sub class C and 
        //passing it to BoundEx as a type parameter.
        BoundEx<C> bec = new BoundEx<C>(new C());
        bec.doRunTest();
        //Creating object of sub class B and 
        //passing it to BoundEx as a type parameter.
        BoundEx<B> beb = new BoundEx<B>(new B());
        beb.doRunTest();
        //similarly passing super class A
        BoundEx<A> bea = new BoundEx<A>(new A());
        bea.doRunTest();
        //If you uncomment below code it will throw compiler error
        //becasue we restricted to only of type A and its sub classes.
        //BoundEx<String> bes = new BoundEx<String>(new String());
        //bea.doRunTest();
    }
}