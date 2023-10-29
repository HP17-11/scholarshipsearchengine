package searchEngine;

import java.util.Scanner;

/**
 * @author SURIL SHUKLA
 *
 */
public class PatternLookup {
	
	public static String suggestion = "";
	
	/**
	 * @param word = word to validate
	 * @return 	if word found in dictionary return same word or else
	 * 			return corrected word.
	 */
	public static String validateWord(String word) {
		AutoCorrect autoCorrect = new AutoCorrect();
		autoCorrect.createDictionary();
		
		String correct[] = word.split(" ");
		String string = "";
		
		for (String str : correct) {
			suggestion = autoCorrect.suggestWords(str.toLowerCase());
				if (!(suggestion.equals(str))) {
					string += suggestion + " ";
				}
				else {
					string+=str+" ";
				}
			}
		if(!string.trim().equalsIgnoreCase(word)) {
			Scanner scanner=new Scanner(System.in);
			String input="n";
			do {
				System.out.println("Did you mean '"+string+"' (y/n)?");
				input = scanner.next();
				switch(input) {
				case "y":
					System.out.println("Displaying Results for: "+ string);
					input="n";
					break;
				case "n":
					input="n";
					string=word;
					break;
					default:
						System.out.println(Constants.defaultMessage);
						input="y";
				}
			}while(input.equalsIgnoreCase("y"));
		}
		return string;
	}
	
	/**
	 * @param data = all the contents of file
	 * @param word = pattern want to search in file
	 * @param fileName = Name of file
	 * @return number of times pattern appeared in a file
	 */
	public static int searchPattern(String data, String word, String fileName) {
		int patternCounter = 0;

		//Search for multiple occurrences of word in the same file
		patternCounter=BoyerMoore.search(word, data).size();
		
		if (patternCounter != 0) {
			System.out.println("\nPresent in >>>>>" + fileName+" >>>>> "+patternCounter+" times"); 
			System.out.println("-------------------------------------------------");
		}
		return patternCounter;		
	}
	public static void main(String[] args) {
		System.out.println(validateWord("computer science"));
		System.out.println("Pattern found "+searchPattern(Constants.testString, "faculty", "Test File Nane")+" times");
	}
}
