package com.java.streams.collect_collectors_grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.Common_MODELS.EmployeeSimple;
 
public class ManyGroupingByExamples {
	
  static List<EmployeeSimple> employeeList = Arrays.asList(
      new EmployeeSimple("3333","Tom Jones", 6),
      new EmployeeSimple("1111","Harry Major", 7),
      new EmployeeSimple("5555","Ethan Hardy", 6),
      new EmployeeSimple("3333","Tom Jones", 4),
      new EmployeeSimple("5555","Ethan Hardy", 4),
      new EmployeeSimple("1111","Harry Major", 6),
      new EmployeeSimple("3333","Tom Jones", 8),
      new EmployeeSimple("3333","Tom Jones", 2));
  
  
  public static void main(String args[]){
	 
	  System.out.println("***** Employee List:");
	  employeeList.forEach(e -> System.out.println(e.toString()) );
	  
	  Map<String,List<EmployeeSimple>> employeeMap = 
			  employeeList.stream()
			  .collect(Collectors.groupingBy(EmployeeSimple::getId));
    
	  System.out.println("\n***** Employees grouped by id");	    
	  employeeMap.forEach((String key, List<EmployeeSimple> empList) -> System.out.println(key +" -> "+empList));
	    
	  
    }
}