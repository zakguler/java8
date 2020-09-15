package com.java.streams.finding_matching;

import java.util.Arrays;

public class AllMatch_RetBoolean_EX {

	public static void main(String[] args) {

		String str = "http://hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Education-Level";
		String profileStr = str.toLowerCase();
		
		String[] education = { "none", "match" };
//		String[] education = { "education", "level", "odd" };
		
		boolean educationFound = Arrays.stream(education).anyMatch(profileStr::contains);

		if (educationFound){
		   System.out.println("anyMatch: found...");
		}else {
			   System.out.println("anyMatch: NOT found...");
		}
	}

}
