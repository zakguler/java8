package com.java.Common_MODELS;

public class EmployeeSimple {
	
	private String id;
	private String name;
	private int vaccineCode;
	
	
	
	public EmployeeSimple(String id, String name, int vaccineCode) {
		super();
		this.id = id;
		this.name = name;
		this.vaccineCode = vaccineCode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVaccineCode() {
		return vaccineCode;
	}
	public void setVaccineCode(int vaccineCode) {
		this.vaccineCode = vaccineCode;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeSimple [id=" + id + ", name=" + name + ", vaccineCode=" + vaccineCode + "]";
	}
	
	
	
}
