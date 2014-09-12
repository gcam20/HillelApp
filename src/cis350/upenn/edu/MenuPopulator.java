package cis350.upenn.edu;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;

import android.util.Log;



public class MenuPopulator implements Populator {

	@Override
	public ArrayList<String> populate(){
		Scraper sc = new MenuScraper();
		
		String url = "http://cms.business-services.upenn.edu/dining/hours-locations-a-menus/kosher-dining-at-falk/daily-menu.html";
		Document parseable = null;
		
		
		try {
			parseable = sc.getParseable(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> results = sc.parseSpecific(parseable);
		Log.d("DEBUGME", "Got results");
		return results;
	}

}
