package com.java;

public class SwitchStatement {

	enum Day {
        MON, TUE, WED, THUR, FRI, SAT, SUN
	};

	public static String getDay (Day today) {
        return switch(today) {
               case MON, TUE  -> "Blues";
		       case WED       -> "Hectic";
		       case THUR, FRI -> "Getting Better";
		       default        -> "Life!";
        };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDay(Day.TUE));
	}

}
