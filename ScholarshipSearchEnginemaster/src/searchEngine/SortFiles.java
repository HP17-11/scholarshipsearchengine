package searchEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

/**
* @author HET PATEL
*         HAARD MEHTA
*         SURIL SHUKLA
*
*/
public class SortFiles {

	
		/**
		 * Method will sort html links based on it's frequency
		 * @param htmlLinks = hashtable of links and its frequency
		 * @param count = number of files in which pattern is found.
		 */
		public static void sort(Hashtable<String, Integer> htmlLinks, int count) {
			// Transfer as List and sort it
			ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<Map.Entry<String, Integer>>(htmlLinks.entrySet());

			Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {

				public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});

			if (count != 0) {

				System.out.println("\n ---- Web pages related to your query ---- \n");
				int webPageCount = 10;
				int i=0;
				for(i=0;i<webPageCount&&arrayList.size()>i;i++) {
					System.out.println(" " + (i+1) + " " + arrayList.get(i).getKey()+" "+arrayList.get(i).getValue());
				}
				System.out.println("\nThese are the top "+ i +" Web pages containing results related to given search \n");
			} 

		}
}
