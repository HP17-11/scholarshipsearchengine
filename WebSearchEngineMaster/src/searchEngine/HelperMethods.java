package searchEngine;

import java.io.File;

/**
 * @author HET PATEL
 *         HAARD MEHTA
 *         SURIL SHUKLA
 *
 */
public class HelperMethods {

	/**
	 * delete Generated files to save memory
	 */
	public static void deleteFiles() {
		File files = new File(Constants.txtDirectoryPath);
		if(files.exists()) {
			File[] fileArray = files.listFiles();

			for (int i = 0; i < fileArray.length; i++) {
				fileArray[i].delete();
			}
			
			File fileshtml = new File(Constants.htmlDirectoryPath);
			File[] fileArrayhtml = fileshtml.listFiles();

			for (int i = 0; i < fileArrayhtml.length; i++) {
				
				fileArrayhtml[i].delete();
			}
		}
	}

}
