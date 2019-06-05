package com.java.Common_MODELS;

import com.java.Common_ENUM.Sex;

public class User implements Comparable<User>{
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


	@Override
	public int compareTo(User o) {
		return getName().compareTo(o.getName());
	}
	  	  
	}

