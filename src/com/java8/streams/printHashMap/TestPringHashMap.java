package com.java8.streams.printHashMap;

import java.util.HashMap;

public class TestPringHashMap {

	public static void main(String[] args) {
		
		HashMap<String, HashMap<String, String>> mapofmaps = new HashMap<>();

	    HashMap<String,String> map1 = new HashMap<>();
	    map1.put("map1_key1", "map1_value1");

	    HashMap<String,String> map2 = new HashMap<>();
	    map2.put("map2_key1", "map2_value1");

	    mapofmaps.put("map1", map1);
	    mapofmaps.put("map2", map2);
	    
//		 // NOTE: map inside a map
//		 // To print the keys and values
	     mapofmaps.forEach((K,V)->{                 // mapofmaps entries
	         V.forEach((X,Y)->{                     // inner Hashmap enteries
	             System.out.println(X+" "+Y);       // print key and value of inner Hashmap 
	         });
	     });

	    //another EX 
		// print list<> inside a map
//		Map<BlogPostType, List<BlogPost>> postsPerType = 
//					posts.stream()
//					.collect(Collectors.groupingBy(BlogPost::getType))	;				
//		
//		postsPerType.forEach((K,V)->{ 
//	         V.forEach((X)->{         
//	             System.out.println(K + ": " + X.getAuthor()); 
//	         });
//	     });


	}

}
