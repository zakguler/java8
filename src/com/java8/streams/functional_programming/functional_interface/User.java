package com.java8.streams.functional_programming.functional_interface;

public class User {
	  private final int age;
	  private final String name;
	  private final Sex sex;

	  public User(int age, String name, Sex sex) {
	    this.age = age;
	    this.name = name;
	    this.sex = sex;
	  }

	  public String getName() {
		return name;
	}

	public int getAge() {
	    return age;
	  }

	  public Sex getSex() {
	    return sex;
	  }

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	  
	  
	  
	}

	enum Sex {
	  MALE, FEMALE
	}
