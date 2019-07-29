package com.java.streams.collect_collectors_grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.Common_MODELS.Dish;
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
  
	static List<Dish> menu = Arrays.asList(
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("seasonal fruit", true, 120, Dish.Type.OTHER)
			);

  
  public static void main(String args[]){
	 
	  System.out.println("\n-----Employee List:");
	  employeeList.forEach(e -> System.out.println(e.toString()) );
	  
	  System.out.println("\n-----Group Employee by id -List");
	  Map<String,List<EmployeeSimple>> employeeMap = 
			  employeeList.stream()
			  .collect(Collectors.groupingBy(EmployeeSimple::getId));
	  
	  employeeMap.forEach((String key, List<EmployeeSimple> empList) -> System.out.println(key +" -> "+empList));
	  
	  //-----------------------------------------------------------------------------------------------------------------    
	  System.out.println("\n-----Group dishes by type -List");
	  
	  Map<Dish.Type, List<Dish>> dType = menu.stream()
			  										.collect( Collectors.groupingBy(Dish::getType) );
//	  dType.forEach( (k,v) -> System.out.println(k + " : " + v.toString()));
	  dType.forEach( (k,v) -> { System.out.print(k + " : " );
	  							v.forEach(x -> System.out.print(x.getName()));
	  							System.out.print("\n");
	  });
	  
	  
	  //-----------------------------------------------------------------------------------------------------------------    
	  System.out.println("\n-----Group dishes by type -List");
	  
//	  Map<Dish.Type, List<Dish>> dType = menu.stream()
//			  										.collect( Collectors.groupingBy(Dish::getType) );
//	  dType.forEach( (k,v) -> System.out.println(k + " : " + v.toString()));
	  		
	  
	  
	  
    }
}