package com.java.streams.collect_collectors_grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TestBlogGroupBy {
	
	public static void main(String[] args) {
		
		List<BlogPost> posts = Arrays.asList(
					new BlogPost("Accountant", "Alan", BlogPostType.REVIEW, 5)
					
					,new BlogPost("NewsCast", "John", BlogPostType.NEWS, 3)
					,new BlogPost("NewsCast", "Scott", BlogPostType.NEWS, 6)
					,new BlogPost("NewsCast", "Scott", BlogPostType.NEWS, 6) //<=== this was made purposely equal
					
					,new BlogPost("BookWriter", "Sam", BlogPostType.GUIDE, 4)
					,new BlogPost("BookWriter", "Hellen", BlogPostType.GUIDE, 2)				
					,new BlogPost("BookWriter", "Hellen", BlogPostType.GUIDE, 10)					
					,new BlogPost("BookWriter", "Hellen", BlogPostType.REVIEW, 8)					
				);
		
		List<Tuple> tuples = Arrays.asList(
				new Tuple(BlogPostType.REVIEW, "Alan")
				,new Tuple(BlogPostType.NEWS, "John")
				,new Tuple(BlogPostType.NEWS, "Scott")
				);
		
//-----------------------------------------------------------------------------		
		// Simple Grouping by a Single Column
		Map<BlogPostType, List<BlogPost>> postsPerType = 
					posts.stream()
//					.filter(p -> p.getType() == BlogPostType.GUIDE || p.getType() == BlogPostType.NEWS)
//					.collect(Collectors.groupingBy(BlogPost::getType))	;				
//					.collect(Collectors.groupingBy(p -> p.getType()))	;				
					.collect(groupingBy(p -> p.getType()))	;				
		
		// generate a Set instead of a list
		Map<BlogPostType, Set<BlogPost>> postsPerTypeSet = 
				posts.stream()
//				.filter(p -> p.getType() == BlogPostType.GUIDE || p.getType() == BlogPostType.NEWS)
//				.collect(Collectors.groupingBy(BlogPost::getType))	;				
//				.collect(Collectors.groupingBy(  p -> p.getType(), Collectors.toSet() ))	;				
				.collect(groupingBy(  p -> p.getType(), toSet() ))	;				

		
//		postsPerTypeSet.forEach((K,V)->{ 
//	         V.forEach((X)->{         
//	             System.out.println(K + ": " + X.getAuthor()); 
//	         });
//	     });
//		
//		System.out.println("=============");
//
//		postsPerTypeSet.forEach((K,V)->{ 
//			System.out.println(V.size()); 
//	    });
//		
//		System.out.println("=============");
//
//		parameterMap.forEach( (String k, String[] v) -> {
//			System.out.print("zak... parameter map: " 
//							+ k 
//							+ " = " 
//							+ String.join(",",  v));
//			System.out.println();
//			}
//		);


		
		
		
//-----------------------------------------------------------------------------		
		// generates <key-is-Object, List<BlogPost> Map
		Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor
			= posts.stream()
//			  .filter(p -> p.getType() == BlogPostType.GUIDE || p.getType() == BlogPostType.NEWS)
//			  .collect(Collectors.groupingBy(p2 -> new Tuple(p2.getType(), p2.getAuthor())));
			  .collect(groupingBy(p2 -> new Tuple(p2.getType(), p2.getAuthor())));
		
//		postsPerTypeAndAuthor.forEach((K,V)->{ 
//	         V.forEach((X)->{         
//	             System.out.println(K.getType() + "/" + K.getAuthor() + ": " + X.getAuthor()); 
//	         });
//	     });
//		
//		System.out.println("=============");
//		
//		postsPerTypeAndAuthor.forEach((K,V)->{ 
//			System.out.println(K.getType() + "/" + K.getAuthor() + ": " +  V.size()); 
//	    });
		

//-----------------------------------------------------------------------------		
		
		// group inside a group
		// To group the List of BlogPosts first by author and then by type:
		Map<String, Map<BlogPostType, List<BlogPost>>> map 
			= posts.stream()
				  .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
		
		
		map.forEach((K,V)->{ 
			System.out.print("String:" + K + ": ");
	        V.forEach((X, Y)->{  
				System.out.print( "--" + "BlogType:" +  X.toString() + ": ");
	            Y.stream()
	            .forEach(z -> System.out.println( "----List:" + z.getType() + "/" + z.getAuthor() ));
	        });
	    });
		
		System.out.println("=============");
		
		map.forEach((K,V)->{ 
			System.out.print( K + ": map.size: " + V.size());
	        V.forEach((X, Y)->{  
				System.out.print( "--" + X.toString() + ": ");
				System.out.println(Y.size());
	        });
	    });

		
//-----------------------------------------------------------------------------	
		// http://www.baeldung.com/java-groupingby-collector
		// Getting the Average from Grouped Results
		
		
		
		
		
		
//-----------------------------------------------------------------------------		
		//------		
//		 // NOTE: map inside a map
//		 // To print the keys and values
//	     mapofmaps.forEach((K,V)->{                 // mapofmaps entries
//	         V.forEach((X,Y)->{                     // inner Hashmap enteries
//	             System.out.println(X+" "+Y);       // print key and value of inner Hashmap 
//	         });
//	     });
		
	}
	
}
