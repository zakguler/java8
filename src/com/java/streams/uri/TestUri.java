package com.java.streams.uri;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestUri {

	String uriDecode;
	String uriEncode;
	
	public static void main(String[] args) throws URISyntaxException {
		
		TestUri t = new TestUri();
//		String testUrl = "http://localhost:4809/death/Patient?family=Cheney*->Hill&_format=json&access_token=dc0ef542-9405-46ad-8e74-758da05db28a";
		String testUrl = "http://localhost:4809/death/Patient?family=Cheney*-Hill&_format=json&access_token=dc0ef542-9405-46ad-8e74-758da05db28a";
//		String testUrl = "http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253";
//		String testUrl = "http://localhost:4809/death/Patient?family=Cheney%2A-%3EHill&_format=json&access_token=dc0ef542-9405-46ad-8e74-758da05db28a";
		System.out.println("testUrl: " + testUrl);
		
		URI uri = new URI(testUrl);
		
		System.out.println("uri.getScheme(): " + uri.getScheme());
		System.out.println("uri.getHost(): " + uri.getHost());
		System.out.println("uri.getRawQuery(): " + uri.getRawQuery());

		String scheme = uri.getScheme();
		String host = uri.getHost();
		String query = uri.getRawQuery();
		
		//
		// encode/decode only the query part of the url
		//
		
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put("family", "Cheney*->Hill");
		requestParams.put("_format", "json");
		requestParams.put("access_token", "dc0ef542-9405-46ad-8e74-758da05db28a");
		
		String encodedURL = requestParams.keySet().stream()
				.map(key -> {
					try {
						return key + "=" + t.encodeValue(requestParams.get(key));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return key;
				})
				.collect(Collectors.joining("&", "http://www.baeldung.com?", ""));
		System.out.println("encode: " + scheme + "://" + host + "?" + encodedURL);
		
		
//	    String decodedQuery = Arrays.stream(query.split("&"))
//	    	      .map(param -> {
//					try {
//						return param.split("=")[0] + "=" + t.decode(param.split("=")[1]);
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return param;
//				})
//	    	      .collect(Collectors.joining("&"));	    
//		System.out.println("decode: " + scheme + "://" + host + "?" + decodedQuery);

	}

	//
	//
	private String encodeValue(String value) throws UnsupportedEncodingException {
	    return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
	}
	
	private String decode(String value) throws UnsupportedEncodingException {
	    return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}
}
