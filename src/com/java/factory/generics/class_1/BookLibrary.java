package com.java.factory.generics.class_1;

import java.awt.print.Book;
import java.util.List;

public class BookLibrary extends Library {
 
	public BookLibrary(List<Book> items) {
		super(items);
	}
 
	public Object issueItem() {
		return super.issueItem();
	}
 
	public void returnItem(Object item) {
		if (item instanceof Book) {
			super.returnItem(item);
		} else {
			// throw some exception as can't add anything other than Book
		}
 
	}
}
 