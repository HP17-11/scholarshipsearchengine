package searchEngine;

/**
 * @author HET PATEL
 *         HAARD MEHTA
 *         SURIL SHUKLA
 *
 *
 */
public class Constants {
	public static final String welcomeMessage = " \t\tWelcome to ScholarQuest\t\t\n"
												+ "\t\uD83D\uDE00\t\uD83D\uDE00\t\uD83D\uDE00\t\uD83D\uDE00\t\uD83D\uDE00\t"
												+ "\n This is a search engine that allows you to effectively search \n for keywords"
												+ " and return corresponding web links.\n"
												+ " Simply enter the branch you want to search for the scholarship\n"
											    + " The rest is upon us \uD83E\uDEE1\t\uD83E\uDEE1 \uD83E\uDEE1\n"
												+ " Please Enter 'y' to Conitue 'n' to Quit (y/n)?\n";
	public static final String defaultMessage="\n Please Select (y/n). \n";
	public static final String htmlDirectoryPath = System.getProperty("user.dir") + "/output/HtmlFiles/";
	public static final String txtDirectoryPath = System.getProperty("user.dir") + "/output/TextFiles/";
	public static final String dictionaryPath=System.getProperty("user.dir")+"/Dictionary/ListOfEnglishWords.txt";
	public static final String stopWordsPath=System.getProperty("user.dir")+"/Dictionary/stop_words_english.txt";
	public static final String [] urls={			//List of libraries for the books to search from with depth 4
//		"https://scholarships360.org/scholarships/top-scholarships-for-graduate-students/",
		"https://www.computerscience.org/scholarships-overview/",
		"https://www.dal.ca/faculty/computerscience/current/scholarships.html",
		"https://www.uwindsor.ca/studentawards/scholarships-bursaries"
	};
	public static final String testString="faculty alongside computer science - dalhousie university support dal current students faculty & staff family & friends campuses agricultural campus (truro) halifax campuses directory campus maps mydal dal online brightspace along mydal directory maps brightspace dal online students faculty & staff family & friends support dal brightspace dal alone online students faculty & staff family & friends support dal dalhousie university admissions academics campus life libraries & innovation almost alumni news & events search dal.ca admissions academics campus life libraries & innovation alumni news & events search dal.ca faculty computer science current students faculty & staff undergraduate allows graduate faculty & staff alumni news & events dal.ca faculty allow computer science code diversity cs centres & institutes study student life careers contact all founded 1997, dalhousie university's faculty computer science premier institution technology atlantic canada. mission ahead ain't develop students deep technical, problem-solving leadership skills needed create - ago leverage - computing technologies empower people, organizations society.";

}
