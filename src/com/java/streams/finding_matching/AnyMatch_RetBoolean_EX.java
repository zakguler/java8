package com.java.streams.finding_matching;

import java.util.Arrays;

public class AnyMatch_RetBoolean_EX {

	public static void main(String[] args) {

		String str = "http://hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Education-Level";
		String profileStr = str.toLowerCase();
		
//		String[] education = { "education", "level" };
		String[] education = { "education", "level", "odd" };
		
		boolean educationFound = Arrays.stream(education).allMatch(profileStr::contains);

		if (educationFound){
		   System.out.println("allMatch: education and level are found...");
		}else {
			   System.out.println("allMatch: NOT found...");
		}
	}

}
