package searchEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * @author HET PATEL
 *
 */
public class HtmlParser {
	
	/**
	 * Method WriteHtml : To create a html file and Save data in it then converting it into a text file
	 * @param document = web page to download
	 * @param url = link of web page
	 */
	public static void writeHtml(Document document, String url) {
		String title = document.title().replaceAll("[^a-zA-Z0-9\\s]", "");
		try {
			PrintWriter html = new PrintWriter(
					new FileWriter(Constants.htmlDirectoryPath + title+ ".html"));
			html.write(document.toString());
			html.close();
			convertToText(Constants.htmlDirectoryPath + title+ ".html", url,title+ ".txt");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method convertToText : To convert the html doc into txt file
	 * @param htmlfile = web page downloaded
	 * @param url = link of web page
	 * @param fname 
	 * @throws Exception
	 */
	public static void convertToText(String htmlfile, String url, String fname) throws Exception {
		FilterInputData filterInputData=new FilterInputData();
		File file = new File(htmlfile);
		Document document = Jsoup.parse(file, "UTF-8");
		String data = document.text().toLowerCase();
		String filteredData=filterInputData.removeStopWords(data);	//remove stop words from the data
		data = url + "<>" + filteredData; 
		PrintWriter newwriter = new PrintWriter(Constants.txtDirectoryPath+ fname);
		newwriter.println(data);
		newwriter.close();
	}
}
