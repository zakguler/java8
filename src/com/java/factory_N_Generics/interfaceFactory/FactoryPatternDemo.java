package com.java.factory_N_Generics.interfaceFactory;

public class FactoryPatternDemo {

	   public static void main(String[] args) {
	      ShapeFactory shapeFactory = new ShapeFactory();

	      //get an object of Circle and call its draw method.
	      Shape shapeCircle = shapeFactory.getShape("CIRCLE");

	      //call draw method of Circle
	      shapeCircle.draw();

	      //get an object of Rectangle and call its draw method.
	      Shape shapeRectangle = shapeFactory.getShape("RECTANGLE");

	      //call draw method of Rectangle
	      shapeRectangle.draw();

	      //get an object of Square and call its draw method.
	      Shape shapeSquare = shapeFactory.getShape("SQUARE");

	      //call draw method of square
	      shapeSquare.draw();
	   }
	}
