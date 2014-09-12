package cis350.upenn.edu;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.util.Log;


public abstract class Scraper {

	public Scraper() {

	}
	/**************************************************************************
	 * Given a web address and an output file name, retrieves HTML from the
	 * website and stores it as text in the output file.
	 * @throws IOException 
	 *************************************************************************/
	public Document getParseable(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		Log.d("DEBUGME", "Got html");
		return doc;
	}
	/**************************************************************************
	 * Searches a file to find the given regex or string. Returns a list of 
	 * strings that match the regex. If multiple identical matches are found,
	 * returns all of them.
	 * @throws FileNotFoundException 
	 *************************************************************************/
	public abstract ArrayList<String> parseSpecific(Document doc);

}
