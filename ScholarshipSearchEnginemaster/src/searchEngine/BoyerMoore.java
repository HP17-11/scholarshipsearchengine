package searchEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SURIL SHUKLA
 *
 */
public class BoyerMoore {
	static Map<Character, Integer> badCharShiftTable = new HashMap<>();

	/**
	 * Method will create Bad Character Shift table for the given pattern
	 * @param pattern
	 */
	public static void badCharacterTable(String pattern) {
		for(int i=0;i<pattern.length();i++) {
			char c = pattern.charAt(i);
			//badCharShiftTable.put(c,pattern.lastIndexOf(pattern.charAt(i)));
			badCharShiftTable.put(c,pattern.length()-i-1);
		}
	}

	/**
	 * Method will return list indices of how many times given 
	 * pattern is present in the text file.
	 * @param pattern
	 * @param text
	 * @return
	 */
	public static List<Integer> search(String pattern, String text) {
		int textLength=text.length();
		int patternLength= pattern.length();
		List<Integer> indices = new ArrayList<>();		//List to store indices of match
		
		if(textLength==0||patternLength==0)
			return indices;
		
		badCharacterTable(pattern);		//create Bad character shift table for the pattern
		
		int i = patternLength - 1;
		int j = patternLength - 1;
		
		while (i < textLength && j>=0) {
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == 0) {
					indices.add(i);			// add matched index to array list
					i += patternLength;		// move i to next word i.e i + length of matched pattern
					continue;				// continue to find next occurrence of pattern.
				}
				i--;
				j--;  
			}
			else {
				// Shift based on the bad character value
				char c = text.charAt(i);
				//if value is present in bad character table return that value else return pattern length
				int badCharShiftAmount = badCharShiftTable.getOrDefault(c, patternLength);
				//i = i+patternLength - Math.min(j, badCharShiftAmount+1);
		        i += Math.max(badCharShiftAmount, patternLength - j);		// shift i value by max of value from 
		        															// bad character table or pattern length - index j
		        															// has moved from right to left
				j=patternLength-1;		// initialize j back to pattern length -1
			}
		}
		return indices;				// return list of indices
	}


	public static void main(String[] args) {

		String text = "this is he feild of he computer science he the the the the it the the it the it it ehe ehe ehe ehe";
		String pattern = "the";
		System.out.println("Given pattern is on indices "+search(pattern, text));
		System.out.println("No of times Pattern appeared in File "+search(pattern, text).size());
	}
}
