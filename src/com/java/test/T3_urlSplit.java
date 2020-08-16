package com.java.test;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class T3_urlSplit {

	public T3_urlSplit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String url = "http://www.example.com/something.html?one=1&two=2&three=3&three=3a";

		Map<String, List<String>> list = 
//		        Pattern.compile("&").splitAsStream(url.getQuery())
		        Pattern.compile("&").splitAsStream("one=1&two=2&three=3&three=3a")
				.map(s -> Arrays.copyOf(s.split("="), 2))
		        .collect(groupingBy(s -> decode(s[0]), mapping(s -> decode(s[1]), toList())));
		
		
		list.forEach( (String k, List<String> v) -> {
			System.out.print(k + " = ");
			v.forEach(w -> System.out.print(w+","));
			System.out.println();
			
		});

	}

	private static String decode(final String encoded) {
	    try {
	        return encoded == null ? null : URLDecoder.decode(encoded, "UTF-8");
	    } catch(final UnsupportedEncodingException e) {
	        throw new RuntimeException("Impossible: UTF-8 is a required encoding", e);
	    }
	}
	
//	public Map<String, List<String>> splitQuery(URL url) {
////	    if (String.isNullOrEmpty(url.getQuery())) {
////	        return Collections.emptyMap();
////	    }
//	    return Arrays.stream(url.getQuery().split("&"))
//	            .map(this::splitQueryParameter)
//	            .collect(Collectors
//	            			.groupingBy(SimpleImmutableEntry::getKey, 
//	            						LinkedHashMap::new, 
//	            						mapping(Map.Entry::getValue, toList())));
//	}
//
//	public SimpleImmutableEntry<String, String> splitQueryParameter(String it) {
//	    final int idx = it.indexOf("=");
//	    final String key = idx > 0 ? it.substring(0, idx) : it;
//	    final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
//	    return new SimpleImmutableEntry<>(
//	        URLDecoder.decode(key, "UTF-8"),
//	        URLDecoder.decode(value, "UTF-8")
//	    );
//	}

}
