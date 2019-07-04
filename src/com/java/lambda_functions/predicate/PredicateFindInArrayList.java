package com.java.lambda_functions.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFindInArrayList {
	 
    String name, role; 
    PredicateFindInArrayList(String a, String b) { 
        name = a; 
        role = b; 
    } 
    String getRole() { return role; } 
    String getName() { return name; }     
    public String toString() { 
       return "User Name : " + name + ", Role :" + role; 
    } 
  
    public static void main(String args[]) 
    {       
        List<PredicateFindInArrayList> users = new ArrayList<PredicateFindInArrayList>(); 
        users.add(new PredicateFindInArrayList("John", "admin")); 
        users.add(new PredicateFindInArrayList("Peter", "member")); 
        List admins = process(users, (PredicateFindInArrayList u) -> u.getRole().equals("admin")); 
        System.out.println(admins); 
    } 
  
    public static List<PredicateFindInArrayList> process(List<PredicateFindInArrayList> users,  
                            Predicate<PredicateFindInArrayList> predicat) 
    { 
        List<PredicateFindInArrayList> result = new ArrayList<PredicateFindInArrayList>(); 
        for (PredicateFindInArrayList user: users)         
            if (predicat.test(user))             
                result.add(user); 
        return result; 
    } 
}
