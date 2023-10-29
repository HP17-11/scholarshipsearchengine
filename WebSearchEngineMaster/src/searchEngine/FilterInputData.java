package searchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author HET PATEL
 *         HAARD MEHTA
 *         SURIL SHUKLA
 *
 */
 
public class FilterInputData {
	//Hashset to avoid duplicates
	Set<String> set = new HashSet<String>();
	static int removedWords=0;							// count can be tracked to check optimization
	List<String> filteredlist = new ArrayList<String>();	//list of filtered data
	
	/**
	 * @param data = stream of data from which stop 
	 * words are to be removed.
	 * @return = filtered text
	 */
	public String removeStopWords(String data) {
		try {
			FileReader fileReader = new FileReader(Constants.stopWordsPath);
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			while ((line = br.readLine()) != null) {
				String word = line.toLowerCase();
				set.add(word);			// add stop words into set
			}
			fileReader.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		String[] splitdata=data.split("\\s");
		for(String str:splitdata) {			
			if(!set.contains(str)) {		//if word is not present in stop word set add it to filtered list
				filteredlist.add(str);
			}
			else if(str.length()>0) {
				removedWords++;
			}
		}
		String filteredText= String.join(" ", filteredlist);	//join the filtered list to make string and return it.
		return filteredText;
	}
	
	public static void main(String[] args) {
		FilterInputData filterInputData=new FilterInputData();
		String inputString=Constants.testString;
		System.out.println("str before:\n"+Constants.testString);
		
		System.out.println("str after:\n"+filterInputData.removeStopWords(inputString));
		System.out.println("No of words removed: "+removedWords);
	
	}
}
