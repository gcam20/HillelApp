package cis350.upenn.edu;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;



public class MenuScraper extends Scraper {

	@Override
	public ArrayList<String> parseSpecific(Document doc) {
		Log.d("DEBUGME", "Starting parseSpecific");
		ArrayList<String> menu = new ArrayList<String>();
		// String to select correct div
		String s = "div#subcontent > div#rightSide > article > table.contentpaneopen > ";
		s = s + "tbody > tr > td > div#accordion1";
		Elements divs = doc.select(s);
		
		// Check all divs
		for (Element div : divs) {
			//Lunch
			menu.addAll(getMenuItems(div, 1));
			menu.add("LUNCH_DINNER_DIVIDER");
			//Dinner
			menu.addAll(getMenuItems(div, 2));
		}
		
		if (menu.isEmpty()) {
			menu.add("Dining hall is closed right now");
		}
		return menu;
	}

	// which: 0 - lunch, 1 - dinner
	private ArrayList<String> getMenuItems(Element div, int which) {
		Log.d("DEBUGME", "Div: " + div.toString()+ "\n\n");
		ArrayList<String> items = new ArrayList<String>();
		Elements divInner = div.select("div");
		// Pick all list items from either lunch or dinner
		Elements lis = divInner.get(which).select("li");
		// Check all li's
		for (Element li : lis) {
			String inner = li.html();
			Log.d("DEBUGME", "found: " + inner);
			items.add(inner);
		}
		
		return items;
	}
	
}
