package cis350.upenn.edu;

import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class HoursScraper extends Scraper {

	@Override
	public ArrayList<String> parseSpecific(Document doc) {
		Log.d("DEBUGME", "Starting parseSpecific - HoursScraper");
		ArrayList<String> hours = new ArrayList<String>();
		//String to select correct div
		String s = "div#subcontent > div#rightSide > article > table.contentpaneopen > ";
		s = s + "tbody > tr > td > ul > li > ul > li";
		Elements divs = doc.select(s);
		hours.addAll(getTodaysHours(divs));
		return hours;
	}
	
	private ArrayList<String> getTodaysHours(Elements divs) {
		ArrayList<String> hours = new ArrayList<String>();
		Calendar rightNow = Calendar.getInstance();
		int i = rightNow.get(Calendar.DAY_OF_WEEK);
		for (Element div : divs) {
			// Monday - Thursday
			String inner = div.html();
			if (i == Calendar.MONDAY || i == Calendar.TUESDAY || i == Calendar.WEDNESDAY || i == Calendar.THURSDAY) {
				if (inner.contains("Lunch// Monday Thru Friday")) {
					hours.add(inner.substring(inner.indexOf("1")));
				} else if (inner.contains("Dinner//Monday Thru Thursday")) {
					hours.add(inner.substring(inner.indexOf("5")));
				}
			// Friday
			} else if (i == Calendar.FRIDAY) {
				if (inner.contains("Lunch// Monday Thru Friday")) {
					hours.add(inner.substring(inner.indexOf("1")));
				}
			// Saturday
			} else if (i == Calendar.SATURDAY) {
				if (inner.contains("Sabbath Lunch//")) {
					hours.add(inner.substring(inner.indexOf("1")));
				}
			//Sunday
			} else {
				
			}
		}
		return hours;
	}

}
