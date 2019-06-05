package com.java.test;

import java.math.BigDecimal;

public class X {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("parseLong(): " + Double.parseDouble("2.01803E+13"));
		System.out.println("BigDecimal to integer(): " + new BigDecimal("2.01803E+13").toBigInteger());
	}

}
