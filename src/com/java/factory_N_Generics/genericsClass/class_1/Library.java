package com.java.factory_N_Generics.genericsClass.class_1;

import java.util.List;
 
public class Library<T> { // "T" is the Type parameter. We can create Library of any Type
 
	private List<T> items ; // represents the list of items of type we will pass
 
	public Library(List<T> items){
		this.items = items;
	}
 
	public Object issueItem(){
		// write code to issue item. 
		return items.get(0);
	}
 
	public void returnItem(T item){ // again pass the same "T" type to issueItem method
		items.add(item);
	}
 
}