package com.java.Common_MODELS;

import com.java.Common_ENUM.Color;

public class Apple {
	Color c;
	Integer weight;
	
	public Apple(Color c, Integer weight) {
		this.c = c;
		this.weight = weight;
	};

	public Color getColor() {
		return c;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	
}
