package com.java.factory.generics.class_1;

import java.util.ArrayList;
import java.util.List;
 
public class TestLibrary {
 
	public static void main(String[] args) {
 
		//-----
		List<Book> books = new ArrayList<Book>();
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
 
		Library<Book> bookLibrary = new Library<Book>(books);
		
		Book book = (Book) bookLibrary.issueItem();
		System.out.println(book);	
		
		//-----
		List<CD> cds = new ArrayList<CD>();
		cds.add(new CD());
		cds.add(new CD());
		cds.add(new CD());
 
		Library<CD> cdLibrary = new Library<CD>(cds);
 
		CD cd = (CD) cdLibrary.issueItem();
		System.out.println(cd);
	}
 
}